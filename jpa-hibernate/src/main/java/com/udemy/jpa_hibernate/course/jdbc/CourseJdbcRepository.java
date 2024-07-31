package com.udemy.jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

	
	// its a field injection. just by @Autowired, we are injecting lots of dependency.. 
	// like creating object of jdbcTemplate, then injecting dependency of jdbcTemplate like datasource etc..
	// it autoconfigures it as we have added package of H2 database while creating project. 
	// spring checks maven dependency to auto configure. 
	// it scans all things. 
	// https://www.baeldung.com/spring-jdbc-jdbctemplate -- without @autowiring
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//3 double quotes excepts block of string statements. and also retains format here. 
	private static String INSERT_QUERY = 
			"""
				insert into course (id,name,author) 
				values (1, 'learn spring', 'in28Minutes');	
			""";
	
	public void insertQuery() {
		jdbcTemplate.update(INSERT_QUERY);
	}

}
