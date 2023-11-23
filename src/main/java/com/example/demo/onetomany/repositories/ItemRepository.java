package com.example.demo.onetomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.onetomany.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	/*
	@Query("select i from Item i inner join fetch i.bids where i.id = :id")
    Item findItemWithBids(@Param("id") Long id);
    */
}
