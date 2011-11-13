package com.kelsonprime.oregontrail.controller;

import javax.swing.JOptionPane;

import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Wagon;

/**
 * Generates random events for the game
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class Events {

	/**
	 * Prevent instantiations of this class
	 */
	private Events(){
		
	}
	
	/**
	 * Generated death
	 * @param wagon Wagon
	 * @param companion Companion
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
	
	/**
	 * Lose random items
	 * @param wagon Wagon to lose from
	 * @param percent Percent of weight to lose
	 */
	public static void loseItems(Wagon wagon, double percent){
		
	}

}
