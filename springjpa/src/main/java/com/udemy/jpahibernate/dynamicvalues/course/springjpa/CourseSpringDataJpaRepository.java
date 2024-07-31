package com.udemy.jpahibernate.dynamicvalues.course.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.jpahibernate.dynamicvalues.course.Course;

//Here Integer is the datatype of primary key. And course is the class which you want to manage. 
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer> {
	

}
