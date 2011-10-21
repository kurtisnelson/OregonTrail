package com.kelsonprime.oregontrail.model;

public class Tongue extends Part {

	public Tongue(int health) {
		super(health);
	}

	public Tongue() {
		this(125);
	}
	
	public String toString() {
		return Wagon.TONGUE;
	}

}