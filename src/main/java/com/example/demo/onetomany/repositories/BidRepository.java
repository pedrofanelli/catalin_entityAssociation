package com.example.demo.onetomany.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.onetomany.models.Bid;
import com.example.demo.onetomany.models.Item;

public interface BidRepository extends JpaRepository<Bid, Long> {
    Set<Bid> findByItem(Item item);
}
