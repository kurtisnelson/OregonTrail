// $codepro.audit.disable noAbstractMethods, com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.preferInterfacesToAbstractClasses
package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

/**
 * Represent a destination followed by vector that points to the next <code>Location</code>
 * @author Kurt Nelson
 * @version 1
 */
public abstract class Location implements Serializable{
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 4027729795704277442L;

	/**
	 * User friendly label
	 */
	private final String label;

	/**
	 * Next location
	 */
	private Location next;

	/**
	 * X distance on map to next location
	 */
	private int roadX1;

	/**
	 * Y distance on map to next location
	 */
	private int roadY1;

	/**
	 * Distance from start
	 */
	private final int position;

	/**
	 * Constructor for Location.
	 * @param label String
	 * @param position int
	 */
	public Location(String label, int position) {
		if(label == null || label.length() <= 0){
			label = "The";
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
		return (int) Math.sqrt(Math.pow(roadX1, 2) + Math.pow(roadY1, 2));
	}

}