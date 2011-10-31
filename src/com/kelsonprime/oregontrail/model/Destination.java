package com.kelsonprime.oregontrail.model;

/**
 * Represent a special landmark that the game ends at.
 * @author Kurt Nelson
 * @version .1
 */
public class Destination extends Landmark {
	/**
	 * Class constructor
	 * @param label What to call this in the UI
	 * @param position How far along the trail is this
	 */
	public Destination(String label, int position){
		super(label, position);
	}

	@Override
	public Location next(){
		return null;
	}
}
