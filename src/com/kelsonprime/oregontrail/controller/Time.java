package com.kelsonprime.oregontrail.controller;

/**
 * Allow objects to change and mutate with time.
 * @author Kurt Nelson
 * @version 1.0
 */
public interface Time {
	
	/**
	 * Eat, age items, adjust heath, rest, and increment the day.
	 */
	public void nextDay();
	
	/**
	 * Checks to see if the object is usable
	 * @return true if it is ready
	 */
	public boolean isReady();
}