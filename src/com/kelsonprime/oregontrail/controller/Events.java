package com.kelsonprime.oregontrail.controller;

import javax.swing.JOptionPane;

import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Wagon;

/**
 * Generates random events for the game
 */
public class Events {

	/**
	 * Prevent instantiations of this class
	 */
	private Events(){
		
	}
	
	/**
	 * Generated death
	 */
	public static void death(Wagon wagon, Companion companion) {
		JOptionPane.showMessageDialog(null, companion + "has died");
		wagon.removeCompanion(companion);
	}

	/**
	 * Randomly calculate an event
	 */
	public static void calculateRandomEvent() {

	}

	/**
	 * Generates next day
	 */
	public static void nextDay() {
		// TODO method stub
	}
	
	public static void loseItems(Wagon wagon, double percent){
		
	}

}
