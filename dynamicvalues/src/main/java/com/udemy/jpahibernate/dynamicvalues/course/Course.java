package com.udemy.jpahibernate.dynamicvalues.course;

public class Course {
	
	private int id;
	private String author;
	private String name;
	
	public Course() {
	
	}
	
	public Course(int id, String author, String name) {
		super();
		this.id = id;
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
