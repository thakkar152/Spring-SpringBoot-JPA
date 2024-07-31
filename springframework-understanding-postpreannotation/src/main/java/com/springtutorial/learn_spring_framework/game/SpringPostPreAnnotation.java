package com.springtutorial.learn_spring_framework.game;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.objenesis.strategy.SingleInstantiatorStrategy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass{
	
	SomeDependency sd;
	
	public SomeClass(SomeDependency sd) {
		this.sd = sd;
		System.out.println("All dependency ready");
	}
	
	@PostConstruct
	public void PostConstructMethod() {
		 System.out.println("Inside Post Construct Method");
	}
	
	@PreDestroy
	public void PreDestroyMethod() {
		System.out.println("Inside Pre Destroy Method");
	}
	
}

@Component
class SomeDependency{
	
}

@Configuration
@ComponentScan
public class SpringPostPreAnnotation {
	public static void main(String[] args) {
		
		
		try (var context = new AnnotationConfigApplicationContext(SpringPostPreAnnotation.class)){
			
			System.out.println("Inside Main");
			
		}


		
	}
}	
