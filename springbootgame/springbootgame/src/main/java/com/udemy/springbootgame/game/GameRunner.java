package com.udemy.springbootgame.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	@Autowired
	private GameInterface game;

	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
