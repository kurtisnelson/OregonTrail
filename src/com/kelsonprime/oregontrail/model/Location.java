package com.kelsonprime.oregontrail.model;

/**
 * Represent a destination followed by vector that points to the next <code>Location</code>
 * @author Kurt Nelson
 * @version .1
 */
public abstract class Location {

	private String label;
	private Location next;
	private int roadX1;
	private int roadY1;
	private int position;

	public Location(String label, int position) {
		if(label == null || label.length() <= 0){
			label = "A";
		}
		this.position = position;
		this.label = label;
	}

	public String toString() {
		return label;
	}
	
	public void setNext(Location l, int dX, int dY){
		next = l;
		roadX1 = dX;
		roadY1 = dY;
	}
	
	public Location next(){
		return next;
	}
	
	public int getPosition(){
		return position;
	}
	
	public int getRoadLength(){
		return (int) Math.sqrt(Math.pow(roadX1,2) + Math.pow(roadY1,2));
	}

}