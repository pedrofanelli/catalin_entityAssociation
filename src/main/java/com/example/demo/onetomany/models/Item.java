package com.example.demo.onetomany.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.example.demo.Constants;

import jakarta.persistence.Entity;
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
     * CASCADE PERSIST: permite que al guardar el entity padre, Item, se guarden también los relacionados a él
     * Y podría usarse también para eliminar con CascadeType.REMOVE
     */
    /*
    @OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST)
    private Set<Bid> bids = new HashSet<>();
	*/
    
    /**
     * USANDO "BAG" es decir, una lista permitiendo duplicados SIN numerar
     */
    @OneToMany(mappedBy = "item")
    private Collection<Bid> bids = new ArrayList<>();
    
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

    public Collection<Bid> getBids() {
        //return Collections.unmodifiableSet(bids);
    	return Collections.unmodifiableCollection(bids);
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }
}
