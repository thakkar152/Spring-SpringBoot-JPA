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
		sdjpa.save(new Course(1, "Chappari" , "Learn Java"));
		sdjpa.save(new Course(2, "Magan", "Learn AWS"));
		sdjpa.save(new Course(3, "Pichu", "Learn GCP"));
		sdjpa.deleteById(1);
		System.out.println(sdjpa.findById(3));
		
		System.out.println(sdjpa.findAll());
		System.out.println(sdjpa.count());
		
		System.out.println(sdjpa.findByAuthor("Pichu"));
		
		System.out.println(sdjpa.findByName("Learn AWS"));
	}
}
