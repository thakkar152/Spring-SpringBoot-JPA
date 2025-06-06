package com.restapi.allannotations.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.restapi.allannotations.model.*;

import com.restapi.allannotations.repository.ItemRepository;

@Service
public class ItemService {

	 @Autowired	
	 private  ItemRepository itemRepository;
	 
	 @Async 
	 public CompletableFuture<String> processItemsAsync(List<Item> items) {
	      try {
	          Thread.sleep(5000); // Simulate a delay (e.g., external API call)
	          itemRepository.saveAll(items); 
	      } catch (InterruptedException e) {
	           throw new RuntimeException("Error processing items asynchronously", e);
	      }
	        return CompletableFuture.completedFuture("Items saved successfully!");
	    }
}
