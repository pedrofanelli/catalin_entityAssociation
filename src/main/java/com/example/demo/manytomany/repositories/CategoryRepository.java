package com.example.demo.manytomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.manytomany.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
