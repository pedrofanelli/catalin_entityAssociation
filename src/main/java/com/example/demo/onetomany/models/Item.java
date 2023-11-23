package com.example.demo.onetomany.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.Constants;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Item {

	@Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "item", // Required for bidirectional association
            fetch = FetchType.LAZY) // The default
    private Set<Bid> bids = new HashSet<>();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Bid> getBids() {
        return Collections.unmodifiableSet(bids);
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }
}
