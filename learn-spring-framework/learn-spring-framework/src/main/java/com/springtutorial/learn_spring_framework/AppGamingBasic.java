package com.springtutorial.learn_spring_framework;

import com.springtutorial.learn_spring_framework.game.GameRunner;
import com.springtutorial.learn_spring_framework.game.MarioGame;
import com.springtutorial.learn_spring_framework.game.SuperContra;

public class AppGamingBasic {

	public static void main(String[] args) {
		var marioGame = new MarioGame();
		var superContra = new SuperContra();
		
		//var gameRunner = new GameRunner(marioGame);
		var gameRunner = new GameRunner(superContra);
		gameRunner.run();
	}

}
