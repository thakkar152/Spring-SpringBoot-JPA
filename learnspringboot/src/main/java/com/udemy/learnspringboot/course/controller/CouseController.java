package com.udemy.learnspringboot.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.learnspringboot.course.bean.Courses;

@RestController
public class CouseController {
	
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return List.of(new Courses(1, "Learn Microservices", "Microservice Devta"), 
				new Courses(2, "Learn Springboot", " Spring Devta"));
	}
	
	@GetMapping("/courses/{id}")
	public Courses getCourseById(){
		
		List<Courses> courseList = new ArrayList<>();
		courseList.add(new Courses(1, "Learn Microservices By ID", "Microservice Devta"));
		courseList.add(new Courses(2, "Learn Springboot", "Spring Devta"));
		
		return courseList.get(0);
	
	}
	

}
