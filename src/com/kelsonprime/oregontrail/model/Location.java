package com.kelsonprime.oregontrail.model;

/**
 * A Location is a destination followed by vector that points to the next Location
 * @author kurt
 *
 */
public abstract class Location {

	private String label;
	private Location next;
	private int roadX1;
	private int roadY1;

	public Location(String label) {
		this.label = label;
	}

	public String label() {
		return label;
	}
	
	void setNext(Location l, int dX, int dY){
		next = l;
		roadX1 = dX;
		roadY1 = dY;
	}
	
	public Location next(){
		return next;
	}
	
	public int getRoadLength(){
		return (int) Math.sqrt(Math.pow(roadX1,2) + Math.pow(roadY1,2));
	}

}