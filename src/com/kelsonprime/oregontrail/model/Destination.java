package com.kelsonprime.oregontrail.model;

/**
 * Represent a special landmark that the game ends at.
 * @author Kurt Nelson
 * @version .1
 */
public class Destination extends Landmark {
	private static final long serialVersionUID = -5276025153428684728L;

	/**
	 * Class constructor
	 * @param label What to call this in the UI
	 * @param position How far along the trail is this
	 */
	public Destination(String label, int position){
		super(label, position);
	}

	/**
	 * Method next.
	 * @return Location
	 */
	@Override
	public Location next(){
		return null;
	}
	
	public String getSoundFileName() {
		return "Game end music.wav";
	}
}
