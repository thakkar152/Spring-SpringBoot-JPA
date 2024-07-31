package com.udemy.jpahibernate.dynamicvalues.course.jpa;


import org.springframework.stereotype.Repository;

import com.udemy.jpahibernate.dynamicvalues.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class JPARepository {
	
	//same as @Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(int id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(int id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

}
