package com.example.demo.manytomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.manytomany.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
