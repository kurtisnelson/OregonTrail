package com.kelsonprime.oregontrail.model;

/**
 * Represents an Axle. Inherits from Part
 * @author Aman
 *
 */
public class Axle extends Part {
	private static final long serialVersionUID = 3548664315971140887L;

	/**
	 * Constructor without arguments
	 */
	public Axle(){
		this(100);
	}
	
	/**
	 * Constructor with health given
	 */
	public Axle(int health) {
		super(health);
	}
	
	/**
	 * Gets the name of the part in string form
	 */
	public String toString() {
		return "Axle";
	}
	
	public static int getWeight(){
		return 5;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Axle){
			Axle ot = (Axle) o;
			return ot.health - this.health;
		}
		return this.toString().compareTo(o.toString());
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Axle){
			Axle a = (Axle) o;
			if(a.getHealth() == this.getHealth())
				return true;
		}
		return false;
	}
	
	public int hashCode(){
		return super.hashCode();
	}
}