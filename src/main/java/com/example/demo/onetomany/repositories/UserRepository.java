package com.example.demo.onetomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.onetomany.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
