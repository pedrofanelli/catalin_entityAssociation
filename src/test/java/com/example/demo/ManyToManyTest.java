package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.configuration.SpringDataConfiguration;
import com.example.demo.manytomany.models.Category;
import com.example.demo.manytomany.models.Item;
import com.example.demo.manytomany.repositories.CategoryRepository;
import com.example.demo.manytomany.repositories.ItemRepository;
import com.example.demo.services.ManyToManyService;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class ManyToManyTest {

	@Autowired
    private ManyToManyService testService;

    @Test
    void testStoreLoadEntities() {

        testService.storeLoadEntities();

    }
}
