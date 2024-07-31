package com.springtutorial.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springtutorial.learn_spring_framework.game.GameInterface;
import com.springtutorial.learn_spring_framework.game.GameRunner;
import com.springtutorial.learn_spring_framework.game.MarioGame;
import com.springtutorial.learn_spring_framework.game.PacMan;
import com.springtutorial.learn_spring_framework.game.SuperContra;

public class AppGamingBasic {

	public static void main(String[] args) {
	
	
		try (var context = new AnnotationConfigApplicationContext(SpringConfiguration.class)){
			
			context.getBean(GameInterface.class).up();
			context.getBean(GameRunner.class).run();
		}
			
	}
}
