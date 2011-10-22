package com.kelsonprime.oregontrail.model;

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