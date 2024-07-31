package com.udemy.springbootgame.game;

import org.springframework.stereotype.Component;

@Component
public interface GameInterface {
	
	public void up();
	public void down();
	public void right();
	public void left();

}
