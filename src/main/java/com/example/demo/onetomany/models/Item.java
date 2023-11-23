package com.example.demo.onetomany.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.Constants;

import jakarta.persistence.CascadeType;
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

    /**
     * BIDIRECTIONAL: el típico caso donde se genera una conexión, y la columna la tiene la entidad que es múltiple
     * y no el dueño (en el caso, el múltiple es Bid, por eso Item no tiene en su tabla los id's de Bid)
     */
    /*
    @OneToMany(mappedBy = "item", // Required for bidirectional association
            fetch = FetchType.LAZY) // The default
    private Set<Bid> bids = new HashSet<>();
	*/
    
    /**
     * CASCADE PERSIST
     */
    @OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST)
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
