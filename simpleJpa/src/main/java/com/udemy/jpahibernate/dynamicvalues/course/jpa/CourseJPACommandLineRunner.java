package com.udemy.jpahibernate.dynamicvalues.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udemy.jpahibernate.dynamicvalues.course.Course;

@Component
public class CourseJPACommandLineRunner implements CommandLineRunner {

	@Autowired
	JPARepository jpar;
	
	@Override
	public void run(String... args) throws Exception {
		jpar.insert(new Course(1, "Learn Java", "Chappari"));
		jpar.insert(new Course(2, "Learn AWS", "Magan"));
		jpar.insert(new Course(3, "Learn GCP", "Pichu"));
		jpar.deleteById(1);
		System.out.println(jpar.findById(3));
	}
	
	

}
