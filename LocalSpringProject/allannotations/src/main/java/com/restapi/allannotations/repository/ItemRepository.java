package com.restapi.allannotations.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.restapi.allannotations.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	//almost all  methods are inbuilt in SpringdataJPA.  
	
	// Custom query to update the 'name' field of an item
	// all explanation in the note. 
	
    @Modifying
    @Transactional
    @Query("UPDATE Item i SET i.name = :name WHERE i.id = :id")
    int udpateItemName(int id, String name);
    
    //Pagination - refer notes about large data. 
    Page<Item> findAll(Pageable pageable); 
    
}
