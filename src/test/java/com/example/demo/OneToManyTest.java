package com.example.demo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.configuration.SpringDataConfiguration;
import com.example.demo.onetomany.models.Bid;
import com.example.demo.onetomany.models.Item;
import com.example.demo.onetomany.repositories.BidRepository;
import com.example.demo.onetomany.repositories.ItemRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class OneToManyTest {

	@Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BidRepository bidRepository;

    @Test
    void storeLoadEntities() {

    	/*
    	 * BIDIRECTIONAL
    	 * 
        Item item = new Item("Foo");
        Bid bid = new Bid(BigDecimal.valueOf(100), item);
        Bid bid2 = new Bid(BigDecimal.valueOf(200), item);

        itemRepository.save(item);
        item.addBid(bid);
        item.addBid(bid2);
        bidRepository.save(bid);
        bidRepository.save(bid2);

        List<Item> items = itemRepository.findAll();
        Set<Bid> bids = bidRepository.findByItem(item);

        assertAll(
                () -> assertEquals(1, items.size()),
                () -> assertEquals(2, bids.size())
        );
        */
    	
    	// CASCADE PERSIST
    	
    	Item item = new Item("Foo");

        Bid bid = new Bid(BigDecimal.valueOf(100), item);
        Bid bid2 = new Bid(BigDecimal.valueOf(200), item);
        item.addBid(bid);
        item.addBid(bid2);

        itemRepository.save(item);

        List<Item> items = itemRepository.findAll();
        Set<Bid> bids = bidRepository.findByItem(item);

        assertAll(
                () -> assertEquals(1, items.size()),
                () -> assertEquals(2, bids.size())
        );

        
        Item retrievedItem = itemRepository.findById(item.getId()).get();

        for (Bid someBid : bidRepository.findByItem(retrievedItem)) {
            bidRepository.delete(someBid);
        }

        itemRepository.delete(retrievedItem);

        List<Item> items2 = itemRepository.findAll();
        Set<Bid> bids2 = bidRepository.findByItem(item);

        assertAll(
                () -> assertEquals(0, items2.size()),
                () -> assertEquals(0, bids2.size())
        );
		
    }
}
