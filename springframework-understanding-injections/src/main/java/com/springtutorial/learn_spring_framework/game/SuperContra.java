package com.springtutorial.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraQualifier")
public class SuperContra implements GameInterface {
	
	public void up() {
		System.out.println("Run Jump");
	}
	public void down() {
		System.out.println("Slide");
	}
	public void left() {
		System.out.println("Run Backward");
	}
	public void right() {
		System.out.println("run forward");
	}

}
