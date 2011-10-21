package com.kelsonprime.oregontrail.model;

public class Axle extends Part {

	public Axle(){
		this(100);
	}
	
	public Axle(int health) {
		super(health);
	}
	
	public String toString() {
		return Wagon.AXLE;
	}
}