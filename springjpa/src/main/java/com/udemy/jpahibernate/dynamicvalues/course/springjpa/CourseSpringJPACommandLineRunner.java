package com.udemy.jpahibernate.dynamicvalues.course.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udemy.jpahibernate.dynamicvalues.course.Course;

@Component
public class CourseSpringJPACommandLineRunner implements CommandLineRunner {

	@Autowired
	CourseSpringDataJpaRepository sdjpa;
	
	@Override
	public void run(String... args) throws Exception {
		sdjpa.save(new Course(1, "Learn Java", "Chappari"));
		sdjpa.save(new Course(2, "Learn AWS", "Magan"));
		sdjpa.save(new Course(3, "Learn GCP", "Pichu"));
		sdjpa.deleteById(1);
		System.out.println(sdjpa.findById(3));
	}
	
	

}
