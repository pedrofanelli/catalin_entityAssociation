package com.example.demo.onetomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.onetomany.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
