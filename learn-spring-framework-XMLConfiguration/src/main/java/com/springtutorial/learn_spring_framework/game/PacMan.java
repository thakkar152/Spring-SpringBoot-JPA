package com.springtutorial.learn_spring_framework.game;

public class PacMan implements GameInterface {

	@Override
	public void up() {
		System.out.println("Go UP");
	}

	@Override
	public void down() {
		System.out.println("Go down");
	}

	@Override
	public void right() {
		System.out.println("Go right");
	}

	@Override
	public void left() {
		System.out.println("Go left");
	}

}
