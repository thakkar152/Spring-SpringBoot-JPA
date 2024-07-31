package com.springtutorial.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan()
public class AppGamingBasic {
	
	public static void main(String[] args) {
	
	
		try (var context = new AnnotationConfigApplicationContext(AppGamingBasic.class)){
			
			context.getBean(GameInterface.class).up();
			context.getBean(GameRunner.class).run();
		}
	}
}
