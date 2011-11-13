package com.kelsonprime.oregontrail.controller;

import java.util.Random;

import javax.swing.JOptionPane;

import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Wagon;

/**
 * Generates random events for the game
 */
public class Events {

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
		
		Random rand = new Random();
		int loseCt = (int) (wagon.countItems() * percent);
		
		
		for(int i = 0; i < loseCt; i++){
			wagon.removeRandomItem();
		}
	}

}
