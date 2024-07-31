package com.springtutorial.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class MarioGame implements GameInterface{

	public void up() {
		System.out.println("Jump");
	}
	public void down() {
		System.out.println("Enter the hole");
	}
	public void left() {
		System.out.println("Go Back");
	}
	public void right() {
		System.out.println("Go forward");
	}
}
