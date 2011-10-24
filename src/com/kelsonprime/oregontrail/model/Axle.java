package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Game;

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
}