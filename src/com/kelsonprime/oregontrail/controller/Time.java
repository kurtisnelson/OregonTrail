package com.kelsonprime.oregontrail.controller;

public interface Time {
	/**
	 * Eat, age items, adjust heath, rest, and increment the day.
	 * @param game Current game state
	 */
	public void nextDay();
	
	public boolean isReady();
}