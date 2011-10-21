package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Game;

public class Wheel extends Part {

	public Wheel(int health) {
		super(health, 5);
	}

	public Wheel() {
		this(80);
	}
	
	public String toString() {
		return "Wheel";
	}
}