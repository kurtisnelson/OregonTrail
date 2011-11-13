package com.kelsonprime.oregontrail.controller;

import javax.swing.JOptionPane;

import java.util.Random;

import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Wagon;

/**
 * Generates random events for the game
 */
public class Events {

	private static Random rand;
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
		int event = rand.nextInt(200);
		if (event < 4)
			;//Catch Sickness
		else if (event < 6)
			;//Random Part Breakdown
		else if (event < 7)
			;//Random Party member Death
		else if (event < 8)
			;//Random Oxen Death
		else if (event < 11)
			;//Theft
		else if (event < 12)
			;//Attacked
		else if (event < 17)
			;//Find Food (only farmer)
		else if (event < 18)
			;//Find Wagon of free stuff
		else if (event < 20)
			;//Oxen Weak (Pace halved)
		else if (event < 22)
			;//Random Party member recovery (health XOR sickness)
		else if (event < 25)
			;//Storm lose days
	}
	
	public static void loseItems(Wagon wagon, double percent){
		
	}

}
