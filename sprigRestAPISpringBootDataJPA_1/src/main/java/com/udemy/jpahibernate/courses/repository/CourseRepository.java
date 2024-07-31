package com.udemy.jpahibernate.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.jpahibernate.courses.bean.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
