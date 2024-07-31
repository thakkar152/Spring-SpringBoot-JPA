package com.udemy.springbootgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemy.springbootgame.game.GameInterface;
import com.udemy.springbootgame.game.GameRunner;
import com.udemy.springbootgame.game.MarioGame;

@SpringBootApplication
public class SpringbootgameApplication {
	

	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootgameApplication.class, args);
		System.out.println("This is simple spring boot project");

		
		try (var context = new AnnotationConfigApplicationContext(SpringbootgameApplication.class)){
		
			context.getBean(GameRunner.class).run();
			
		}
		
		
	}

}
