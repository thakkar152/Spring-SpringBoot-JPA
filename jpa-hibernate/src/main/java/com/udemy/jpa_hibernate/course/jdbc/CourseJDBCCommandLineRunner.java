package com.udemy.jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner{

	//here we are implementing CommandLineRunner as we want this to run at the start of application itself.
	
	// here we want cjr object to be managed by spring. We do want to create an object or we do not want to call context.getBean 
	// and run insertQuery method. 
	
	// without autowire example - https://www.codejava.net/frameworks/spring-boot/connect-to-h2-database-examples
	// I have also asked in the course itself why to use Autowired here. I have also recived reply. 
	
	// just remember that if we are creating object of any class object just mark it as autowired.. I guess that should work. 
	
	@Autowired
	private CourseJdbcRepository cjr;
	
	@Override
	public void run(String... args) throws Exception {
		cjr.insertQuery();
	}

}
