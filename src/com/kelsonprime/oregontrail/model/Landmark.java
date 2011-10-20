package com.kelsonprime.oregontrail.model;

import javax.swing.ImageIcon;

/**
 * Represents a <code>Location</code> that is purely a marker along the map and has no functionality.
 * @author Kurt Nelson
 * @version .1
 */
public class Landmark extends Location {
	ImageIcon background;
	/**
	 * Class constructor
	 * @param label What to call this in the UI
	 * @param background A picture to display in the UI
	 */
	public Landmark(String label, ImageIcon background){
		super(label);
		this.background = background;
	}
}
