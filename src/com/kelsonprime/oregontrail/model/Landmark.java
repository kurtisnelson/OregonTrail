package com.kelsonprime.oregontrail.model;

/**
 * Represents a <code>Location</code> that is purely a marker along the map and has no functionality.
 * @author Kurt Nelson
 * @version .1
 */
public class Landmark extends Location {
	private static final long serialVersionUID = 6878086078798787862L;

	/**
	 * Class constructor
	 * @param label What to call this in the UI
	 * @param position How far along the map this is
	 */
	public Landmark(String label, int position){
		super(label, position);
	}
}
