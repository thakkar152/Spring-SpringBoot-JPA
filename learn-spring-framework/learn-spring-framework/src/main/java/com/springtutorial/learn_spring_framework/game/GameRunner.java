package com.springtutorial.learn_spring_framework.game;

public class GameRunner {
	
	//Gamerunner is tightly coupled to either of the game. 
	
	//private MarioGame game;
	
//	public GameRunner(MarioGame game){
//		this.game = game;
//	}
	
	private SuperContra game;

	public GameRunner(SuperContra game){
		this.game = game;
	}

	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}


	
}
