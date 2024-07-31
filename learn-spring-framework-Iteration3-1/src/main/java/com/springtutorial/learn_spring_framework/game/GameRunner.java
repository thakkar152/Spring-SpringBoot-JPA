package com.springtutorial.learn_spring_framework.game;

public class GameRunner {
	
	private GameInterface game;

	public GameRunner(GameInterface game){
		this.game = game;
	}

	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}


	
}
