package com.kelsonprime.oregontrail.model;

import javax.swing.ImageIcon;

/**
 * Represent a special landmark that the game ends at.
 * @author Kurt Nelson
 * @version .1
 */
public class Destination extends Landmark {
	/**
	 * Class constructor
	 * @param label What to call this in the UI
	 * @param background A picture to display in the UI
	 */
	public Destination(String label, ImageIcon background){
		super(label, background);
	}
	
	@Override
	public Location next(){
		return null;
	}
}
