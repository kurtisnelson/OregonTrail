package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Game;

public class Axle extends Part {

	public Axle(){
		this(100);
	}
	
	public Axle(int health) {
		super(health, 5);
	}
	
	public String toString() {
		return "Axle";
	}
}