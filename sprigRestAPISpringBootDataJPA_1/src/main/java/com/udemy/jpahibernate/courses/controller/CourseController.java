package com.udemy.jpahibernate.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.jpahibernate.courses.repository.CourseRepository;
import com.udemy.jpahibernate.courses.bean.Course;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository repository;
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return repository.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public Optional<Course> getCourseById(@PathVariable int id){
	
		Optional<Course> findById = repository.findById(id);
		if (findById.isEmpty()) {
			throw new RuntimeException("Course Id not found : " + id);
		}
		return findById;
	
	}
	
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
	}
	
	//if entity exists then it updates, if it does not exist then it inserts. 
	//it will work without pathvariable {id} as well but its not a good practice.. When we want to update we know the id..
	@PutMapping("/courses/{id}")
	public void udpateCourse(@PathVariable int id, @RequestBody Course course) {
		repository.save(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void udpateCourse(@PathVariable int id) {
		repository.deleteById(id);
	}
}
