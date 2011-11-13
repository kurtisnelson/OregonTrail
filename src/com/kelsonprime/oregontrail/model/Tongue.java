package com.kelsonprime.oregontrail.model;

public class Tongue extends Part {
	private static final long serialVersionUID = 8766537377409751997L;

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

	@Override
	public boolean equals(Object o) {
		if(o instanceof Tongue){
			Tongue a = (Tongue) o;
			if(a.getHealth() == this.getHealth())
				return true;
		}
		return false;
	}
	
	public int hashCode(){
		return super.hashCode();
	}
}