package com.kelsonprime.oregontrail.controller;

import java.util.Random;

import javax.swing.JOptionPane;

import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Farmer;
import com.kelsonprime.oregontrail.model.Game;
import com.kelsonprime.oregontrail.model.Item;
import com.kelsonprime.oregontrail.model.Player;
import com.kelsonprime.oregontrail.model.Wagon;

/**
 * Generates random events for the game
 * 
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class Events {

	private static Random rand = new Random();

	/**
	 * Prevent instantiations of this class
	 */
	private Events() {

	}

	/**
	 * Generated death
	 * 
	 * @param wagon
	 *            Wagon
	 * @param companion
	 *            Companion
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
	public static void nextDay(Game game) {
		int event = rand.nextInt(25);
		Wagon wagon = game.getWagon();
		Player player = wagon.getPlayer();
		if (event < 4)
			;// Catch Sickness
		//else if (event < 6)
		//	;// Random Part Breakdown
		//else if (event < 7)
		//	;// Random Party member Death
		//else if (event < 8)
		//	;//Random Oxen Death
		else if (event < 11){
			//Theft
			JOptionPane.showMessageDialog(null, "1 " + wagon.removeRandomItem() + " has been stolen from you!");
		}
		else if (event < 12)
			;//Attacked
		else if (event < 17){
			if (player.getOccupation() instanceof Farmer)
				try {
					int gained = rand.nextInt(25)+25;
					wagon.add(Item.FOOD, gained);
					JOptionPane.showMessageDialog(null, "You find " + Integer.valueOf(gained) + "lbs of food!");
				} catch (UserInputException e) {
					e.printStackTrace();
				}
		}
		else if (event < 18)
			;// Find Wagon of free stuff
		else if (event < 20)
			;// Oxen Weak (Pace halved)
		else if (event < 22)
			;// Random Party member recovery (health XOR sickness)
		else if (event < 25)
			;// Storm lose days
	}
	
	/**
	 * Lose random items
	 * @param wagon Wagon to lose from
	 * @param percent Percent of weight to lose
	 */
	public static void loseItems(Wagon wagon, double percent){
		
		int foodCt, clothesCt, partCt, bulletCt, spareCt;
		foodCt = clothesCt = partCt = bulletCt = spareCt = 0;
		String cur;
		int loseCt = (int) (wagon.countItems() * percent);
		
		for (int i = 0; i < loseCt; i++) {
			cur = wagon.removeRandomItem();
			if (cur == null){
				break;
			} else if (cur.equals("food")){
				foodCt += 1;
			} else if (cur.equals("clothes")){
				clothesCt += 1;
			} else if (cur.equals("bullet")){
				bulletCt += 1;
			} else if (cur.equals("spare"))
				spareCt += 1;
			}
		
		}
	}
