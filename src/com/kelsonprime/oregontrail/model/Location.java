package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

/**
 * Represent a destination followed by vector that points to the next <code>Location</code>
 * @author Kurt Nelson
 * @version .1
 */
public abstract class Location implements Serializable{
	private static final long serialVersionUID = 4027729795704277442L;

	private String label;

	private Location next;

	private int roadX1;

	private int roadY1;

	private int position;

	/**
	 * Constructor for Location.
	 * @param label String
	 * @param position int
	 */
	public Location(String label, int position) {
		if(label == null || label.length() <= 0){
			label = "A";
		}
		this.position = position;
		this.label = label;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	public String toString() {
		return label;
	}
	
	/**
	 * Method setNext.
	 * @param l Location
	 * @param dX int
	 * @param dY int
	 */
	public void setNext(Location l, int dX, int dY){
		next = l;
		roadX1 = dX;
		roadY1 = dY;
	}
	
	/**
	 * Method next.
	 * @return Location
	 */
	public Location next(){
		return next;
	}
	
	/**
	 * Method getPosition.
	 * @return int
	 */
	public int getPosition(){
		return position;
	}
	
	/**
	 * Method getRoadLength.
	 * @return int
	 */
	public int getRoadLength(){
		return (int) Math.sqrt(Math.pow(roadX1,2) + Math.pow(roadY1,2));
	}

}