package com.springtutorial.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springtutorial.learn_spring_framework.game.GameInterface;
import com.springtutorial.learn_spring_framework.game.GameRunner;

@Configuration
@ComponentScan("com.springtutorial.learn_spring_framework.game")
public class AppGamingBasic {
	
	public static void main(String[] args) {
	
	
		try (var context = new AnnotationConfigApplicationContext(AppGamingBasic.class)){
			
			context.getBean(GameInterface.class).up();
			
			//Instead of looking at configuration file to find which beans are available with GameInterface return type to inject in GameRunner, 
			//It check which classes has @Component defined which can be injected here ... 
			context.getBean(GameRunner.class).run();
		}
	}
}
