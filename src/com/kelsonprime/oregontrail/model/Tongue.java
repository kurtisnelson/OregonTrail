package com.kelsonprime.oregontrail.model;

public class Tongue extends Part {

	public Tongue(int health) {
		super(health);
	}

	public Tongue() {
		this(125);
	}
	
	public static int getWeight(){
		return 5;
	}
	
	public String toString() {
		return "Tongue at "+health;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Tongue){
			Tongue ot = (Tongue) o;
			return ot.health - this.health;
		}
		return this.toString().compareTo(o.toString());
	}

	
}