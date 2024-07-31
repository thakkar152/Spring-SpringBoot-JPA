package com.udemy.jpahibernate.dynamicvalues.course.springjpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.jpahibernate.dynamicvalues.course.Course;

//Here Integer is the datatype of primary key. And course is the class which you want to manage. 
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer> {
	
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
	
	

}
