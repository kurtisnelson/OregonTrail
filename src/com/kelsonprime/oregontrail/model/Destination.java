package com.kelsonprime.oregontrail.model;

/**
 * A destination is a special landmark that the game ends at.
 * @author kurt
 *
 */
public class Destination extends Landmark {
	public Destination(String label){
		super(label);
	}
	
	public Location next(){
		return null;
	}
}
