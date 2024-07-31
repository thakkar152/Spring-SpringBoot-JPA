package com.springtutorial.learn_spring_framework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springtutorial.learn_spring_framework.game.GameInterface;
import com.springtutorial.learn_spring_framework.game.GameRunner;
import com.springtutorial.learn_spring_framework.game.MarioGame;
import com.springtutorial.learn_spring_framework.game.PacMan;
import com.springtutorial.learn_spring_framework.game.SuperContra;

@Configuration
public class SpringConfiguration {
	
	@Bean(name = "mariogame")
	public GameInterface mario() {
		GameInterface game = new MarioGame();
		return game;
	}
	
		
	@Bean
	public GameRunner gameRunner(GameInterface mariogame) {
		//By bean
		//GameRunner gameRunner = new GameRunner(mario());
		
		//By parameter  .. here it sees, what gamerunner needs, it finds that it needs GameInterface object... then it sees, what spring is managing.. 
		// and it find bean with GameInterface . 
		//in its configuration, so it injects that bean...
		// If I introduced one more bean with same return type GameInterface then it will throw an error No qualifying bean of type... etc..
		
		GameRunner gameRunner = new GameRunner(mariogame);
		return gameRunner;
	}
	
}
