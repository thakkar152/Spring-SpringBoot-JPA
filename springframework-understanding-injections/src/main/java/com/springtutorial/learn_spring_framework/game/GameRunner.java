package com.springtutorial.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	// This is field injection. 
    //@Autowired
	private GameInterface game;

	// This is constructor Injection
	// its default and no need of @Autowire annotation.
	public GameRunner(GameInterface game){
		this.game = game;
	}
	
	
	//This is setter injection.
	//@Autowired
	public void setGame(GameInterface game) {
		this.game = game;
	}

	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}

	
}
