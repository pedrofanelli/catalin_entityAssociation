package com.example.demo.onetomany.models;

import java.math.BigDecimal;

import com.example.demo.Constants;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Bid {

	@Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

	/**
	 * BIDIRECTIONAL
	 */
	/*
    @ManyToOne(fetch = FetchType.LAZY) // Defaults to EAGER
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;
	*/
	
	/**
	 * CASCADE PERSIST
	 */
	/*
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;
	*/
	
	/**
	 * Usando BAG, modo más simple y sencillo
	 */
	@ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Item item;

    @NotNull
    private BigDecimal amount;

    public Bid() {
    }

    public Bid(BigDecimal amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
