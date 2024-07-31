package com.udemy.jpahibernate.dynamicvalues.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udemy.jpahibernate.dynamicvalues.course.Course;

@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner {

	@Autowired
	JdbcRepository jr;
	
	@Override
	public void run(String... args) throws Exception {
		jr.insertQuery(new Course(1, "Learn Java", "Chappari"));
		jr.insertQuery(new Course(2, "Learn AWS", "Magan"));
		jr.insertQuery(new Course(3, "Learn GCP", "Pichu"));
		jr.deleteById(1);
		System.out.println(jr.findById(3));
	}
	
	

}
