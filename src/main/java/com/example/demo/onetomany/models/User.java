package com.example.demo.onetomany.models;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.Constants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
public class User {

	@Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    private String username;

    @OneToMany(mappedBy = "buyer")
    private Set<Item> boughtItems = new HashSet<>();

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Item> getBoughtItems() {
        return this.boughtItems;
    }
}
