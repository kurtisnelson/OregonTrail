package com.kelsonprime.oregontrail.model;

/**
 * Represents an Axle. Inherits from Part
 * @author Aman
 *
 */
public class Axle extends Part {

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
		super(health, 5);
	}
	
	/**
	 * Gets the name of the part in string form
	 */
	public String toString() {
		return "Axle";
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Axle){
			Axle ot = (Axle) o;
			return ot.health - this.health;
		}
		return this.toString().compareTo(o.toString());
	}
}