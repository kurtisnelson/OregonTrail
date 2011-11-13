package com.kelsonprime.oregontrail.controller;

/**
 * An interface to allow the class to receive updates from a GameEventListener
 * @author Kurt
 */
public interface Updatable {
	/**
      * Game state has changed
	  */
	public void update();
}
