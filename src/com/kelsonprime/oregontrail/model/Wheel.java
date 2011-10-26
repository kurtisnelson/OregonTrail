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

	@Override
	public int compareTo(Object o) {
		if(o instanceof Wheel){
			Wheel ot = (Wheel) o;
			return ot.health - this.health;
		}
		return this.toString().compareTo(o.toString());
	}
}