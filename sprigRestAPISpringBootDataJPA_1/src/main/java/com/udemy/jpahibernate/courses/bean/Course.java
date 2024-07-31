package com.udemy.jpahibernate.courses.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="author")
	private String author;
	
	@Column(name = "name")
	private String name;
	
	public Course() {
	
	}
	
	public Course( String author, String name) {
		super();
		this.author = author;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getName() {
		return name;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", author=" + author + ", name=" + name + "]";
	}
	

}
