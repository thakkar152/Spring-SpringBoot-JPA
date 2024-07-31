package com.springtutorial.learn_spring_framework.game;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class Dependency1{
	
}

@Component
@Lazy
class Dependency2{
	
	private Dependency1 dp;
	public Dependency2(Dependency1 dp) {
		System.out.println("Its loading as soon as context is initialized");
		this.dp = dp;
	}

}

@Configuration
@ComponentScan
public class LazyLoadingUnderstanding {
	public static void main(String[] args) {
		
		
		try (var context = new AnnotationConfigApplicationContext(LazyLoadingUnderstanding.class)){
			
			System.out.println("Inside Main");
			
			context.getBean(Dependency2.class);
			
					
			System.out.println("Here if I remove @Lazy then beans will be loaded at spring loading thats Eager Initialization\n"
					+ "But if I introduce @Lazy then beans wont get loaded at initialization, but it will be oaded only when its being called by getBean"
					+ "");

		}


		
	}
}	
