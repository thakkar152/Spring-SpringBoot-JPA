package com.restapi.allannotations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.allannotations.model.ItemDetail;

public interface ItemDetailRepository extends JpaRepository<ItemDetail, Integer> {

}
