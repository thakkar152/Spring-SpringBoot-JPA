package com.springtutorial.learn_spring_framework;

import com.springtutorial.learn_spring_framework.game.GameInterface;
import com.springtutorial.learn_spring_framework.game.GameRunner;
import com.springtutorial.learn_spring_framework.game.MarioGame;
import com.springtutorial.learn_spring_framework.game.PacMan;
import com.springtutorial.learn_spring_framework.game.SuperContra;

public class AppGamingBasic {

	public static void main(String[] args) {
	
		//here var is actually interface like.... GameInterface marioGame = new MarioGame();
		
		var marioGame = new MarioGame();
		var superContra = new SuperContra();
		GameInterface pacMan = new PacMan();
		
		var gameRunnerMario = new GameRunner(marioGame);
		gameRunnerMario.run();
		
		var gameRunnerContra = new GameRunner(superContra);
		gameRunnerContra.run();
		
		var gameRunnerPacMan = new GameRunner(pacMan);
		gameRunnerPacMan.run();
		
	}

}
