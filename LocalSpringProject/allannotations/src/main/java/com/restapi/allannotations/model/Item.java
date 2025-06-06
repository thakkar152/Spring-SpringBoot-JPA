package com.restapi.allannotations.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Item {
	
	//these validation gets kicked in by using @Valid in controller. refer notes. 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="name")
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	private String description;
	
	private String sku;
	
	@OneToOne(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
    private ItemDetail itemDetail;
	

	public Item() {
		super();
	}

	public Item(String name, String description, String sku) {
		super();
		this.name = name;
		this.description = description;
		this.sku = sku;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	

	public ItemDetail getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(ItemDetail itemDetail) {
		this.itemDetail = itemDetail;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", sku=" + sku + "]";
	}
	

	
}
