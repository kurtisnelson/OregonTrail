

package com.kelsonprime.oregontrail.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.PassNight;

/**
 * Represents a wagon and it's contents
 * @author Kurt Nelson
 * @version .1
 */
public class Wagon implements PassNight {
	
	public static final String OXEN = "oxen";
	private int oxen;
	private int food;
	public static final String FOOD = "food";
	private int clothes;
	public static final String CLOTHES = "clothes";
	private int bullets;
	public static final String WHEEL = "wheel";
	private int wheel;
	public static final String TONGUE = "tongue";
	private int tongue;
	public static final String AXLE = "axle";
	private int axle;
	public static final String BULLETS = "bullets";
	private Collection<Part> activeParts;
	private Collection<Part> spareParts;
	private Collection<Companion> party;
	private int money;
	private int wagonWeight;

	/**
	 * Create an empty wagon with fresh parts and put in companions.
	 * @param player The driver of the wagon
	 * @param companions All other party members.
	 * @pre player != null
	 * @post money == 0 && clothes == 0 && oxen == 0 && food == 0
	 */
	public Wagon(Player player, List<Companion> companions) {
		party = new ArrayList<Companion>();
		party.add(player);
		party.addAll(companions);
		activeParts = new ArrayList<Part>();
		// TODO setup initial parts
		spareParts = new ArrayList<Part>();
		money = player.startingMoney();
		bullets = 0;
		clothes = 0;
		food = 0;
		oxen = 0;
		wagonWeight = 0;
	}

	/**
	 * Simulate one night passing for all wagon contents
	 * @param game
	 * @pre party.length() > 0 && game != null
	 * @invariant money, bullets
	 * @post food < $pre(int, food)
	 */
	@Override
	public void passNight(Game game) {
		// TODO method stub
	}

	/**
	 * Checks if the user has enough money to spend without debt.
	 * @param moneyNeeded
	 * @return no debt incurred
	 * @pre moneyNeeded >= 0
	 * @invariant money
	 */
	
	public int getWagonWeight(){
		return wagonWeight;
	}
	public boolean checkMoney(int moneyNeeded) {
		if(money >= moneyNeeded)
				return true;
		return false;
	}

	/**
	 * Return how much money is contained in the Wagon
	 * @return money available
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Tries to change amount of money in the wagon by amount
	 * @param amount
	 * @pre amount != 0 && money + amount >= 0
	 * @post money == $pre(int, money) + amount
	 */
	public void changeMoney(int amount) {
		money += amount;
	}
	

	public void add(List<Part> parts){
		// TODO Check the wagon weight everytime we add a part
		for(Part p : parts){
			spareParts.add(p);
		}
		getWagonWeight();
		// TODO run repair function to move spareParts -> activeParts as appropriate
	}

	public void add(String part, int quantity){
		// TODO Implement part weights!
		if(part.equals(OXEN)){
			// TODO set limit on oxen quantity
			oxen += quantity;
			wagonWeight += oxen;
		}else if(part.equals(BULLETS)){
			bullets += quantity;
			wagonWeight += bullets;
		}else if(part.equals(FOOD)){
			food += quantity;
			wagonWeight += food;
		}else if(part.equals(CLOTHES)){
			clothes += quantity;
			wagonWeight += clothes;
		}else if(part.equals(WHEEL)){
			wheel += quantity;
			wagonWeight += wheel;
		}else if(part.equals(TONGUE)){
		tongue += quantity;
		wagonWeight += tongue;
	    }else if(part.equals(AXLE)){
			axle += quantity;
			wagonWeight += axle;
	    }
		//etc
	}
	
	/**
	 * Repairs the wagon with available parts
	 * @return Wagon fully repaired
	 */
	public boolean repair(){
		
		//TODO if parts in activeParts are broken, try moving parts from spare.
		return true;
	}

}

