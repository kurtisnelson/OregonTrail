package com.kelsonprime.oregontrail.controller;

import java.util.Random;

import javax.swing.JOptionPane;

import com.kelsonprime.oregontrail.model.Axle;
import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Farmer;
import com.kelsonprime.oregontrail.model.Game;
import com.kelsonprime.oregontrail.model.Item;
import com.kelsonprime.oregontrail.model.Player;
import com.kelsonprime.oregontrail.model.Tongue;
import com.kelsonprime.oregontrail.model.Wagon;
import com.kelsonprime.oregontrail.model.Wheel;

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
		JOptionPane.showMessageDialog(null, companion.getName() + " has suddenly died :(");
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
		int event = rand.nextInt(200);
		Wagon wagon = game.getWagon();
		Player player = wagon.getPlayer();
		if (event < 4)
			// Catch Sickness
			wagon.giveRandomSickness();
		else if (event < 6)
			;// Random Part Breakdown
		else if (event < 7){
			//Random party member death
			wagon.killRandomPartyMember();
		}
		else if (event < 8){
			//Random Oxen Death
			if (wagon.countOxen() > 1){
				try {
					wagon.add(Item.OXEN, -1);
				} catch (UserInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "1 of your oxen has suddenly died!");
			}
		}
		else if (event < 11){
			//Theft
			String item = wagon.removeRandomItem();
			if (item != null)
				JOptionPane.showMessageDialog(null, "1 " + item + " has been stolen from you!");
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
			try {
				wagon.add(new Wheel());
				wagon.add(new Axle());
				wagon.add(new Tongue());
				JOptionPane.showMessageDialog(null, "You find an abandoned wagon and gather\nthe parts from the wagon.\n You've gained:\n1 Wheel\n1 Axle\n1 Tongue.");
			} catch (UserInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if (event < 20)
			;// Oxen Weak (Pace halved)
		else if (event < 22)
			;// Random Party member recovery (health XOR sickness)
		else
			;// Storm lose days
	}
	
	/**
	 * Lose random items
	 * @param wagon Wagon to lose from
	 * @param percent Percent of weight to lose
	 */
	public static void loseItems(Wagon wagon, double percent){
		
		int foodCt, clothesCt, bulletCt, axleCt, wheelCt, tongueCt;
		foodCt = clothesCt = bulletCt = axleCt = wheelCt = tongueCt = 0;
		String cur;
		int loseCt = (int) (wagon.countItems() * percent);
		
		for (int i = 0; i < loseCt; i++) {
			cur = wagon.removeRandomItem();
			if (cur == null)
				break;
			else if (cur.equals("food"))
				foodCt ++;
			else if (cur.equals("clothes"))
				clothesCt ++;
			else if (cur.equals("bullet"))
				bulletCt ++;
			else if (cur.equals("axle"))
				axleCt ++;
			else if (cur.equals("tongue"))
				tongueCt++;
			else if (cur.equals("wheel"))
				wheelCt++;
		}
		JOptionPane.showMessageDialog(null, "You have lost:\n" + foodCt + "lbs of Food\n" + clothesCt + " Clothes\n" + bulletCt + " Bullets\n" + axleCt + " Spare Axles\n" + wheelCt + "  Spare Wheels\n" + tongueCt + " Spare Tongues");
		}
	}
