package com.kelsonprime.oregontrail.model;

public class Wheel extends Part {

	public Wheel(int health) {
		super(health);
	}

	public Wheel() {
		this(80);
	}
	
	public static int getWeight(){
		return 5;
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
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Wheel){
			Wheel a = (Wheel) o;
			if(a.getHealth() == this.getHealth())
				return true;
		}
		return false;
	}	
}