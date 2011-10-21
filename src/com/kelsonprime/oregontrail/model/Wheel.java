package com.kelsonprime.oregontrail.model;

public class Wheel extends Part {

	public Wheel(int health) {
		super(health);
	}

	public Wheel() {
		this(80);
	}
	
	public String toString() {
		return Wagon.WHEEL;
	}
}