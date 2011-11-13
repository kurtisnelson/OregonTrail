package com.kelsonprime.oregontrail.model;

/**
 * Allow models to change and mutate with time.
 * @author Kurt Nelson
 * @version 1.0
 */
public interface Time {
	
	/**
	 * Eat, age items, adjust heath, rest, and increment the day.
	 * @param game Game
	 */
	public void nextDay(Game game);
	
	/**
	 * Checks to see if the object is usable
	
	 * @return true if it is ready */
	public boolean isReady();
}