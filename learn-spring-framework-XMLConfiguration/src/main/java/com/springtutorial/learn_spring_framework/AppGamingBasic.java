package com.springtutorial.learn_spring_framework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtutorial.learn_spring_framework.game.GameInterface;
import com.springtutorial.learn_spring_framework.game.GameRunner;



//@Configuration
//@ComponentScan("com.springtutorial.learn_spring_framework.game")
public class AppGamingBasic {
	
	public static void main(String[] args) {
	
	
		try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
			
			
			System.out.println("===Bean Defined======");
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println("===Bean Outputs======");
			
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();
			
		}
	}
}
