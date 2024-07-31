package com.udemy.jpahibernate.dynamicvalues.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.udemy.jpahibernate.dynamicvalues.course.Course;

@Repository
public class JdbcRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String INSERT_QUERY = """ 
						INSERT into course (id,name,author) 
							values (?,?,?);
			""" ;
	
	private static String DELETE_QUERY = """ 
			DELETE from course where id = ? ;
			""" ;
	
	private static String SELECT_QUERY = """ 
			SELECT * FROM course WHERE id = ? ;
			""" ;
	
	
	public void insertQuery(Course course) {
		jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(int id) {
		jdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(int id) {
		return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}

}
