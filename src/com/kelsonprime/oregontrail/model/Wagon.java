package com.kelsonprime.oregontrail.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.kelsonprime.oregontrail.controller.Time;
import com.kelsonprime.oregontrail.controller.UserInputException;

/**
 * Represents a wagon and it's contents
 * @author Kurt Nelson
 * @version .1
 */
public class Wagon implements Time {
	
	public static final String OXEN = "oxen";
	private int oxen;
	private int food;
	public static final String FOOD = "food";
	private int clothes;
	public static final String CLOTHES = "clothes";
	private int bullets;
	public static final String BULLETS = "bullets";
	private Collection<Part> activeParts;
	private Collection<Part> spareParts;
	private Collection<Companion> party;
	private int money;
	private int wagonWeight;
	static final int MAXWEIGHT = 100;

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
	 * @pre party.length() > 0 && game != null
	 * @invariant money, bullets
	 * @post food < $pre(int, food)
	 */
	@Override
	public void nextDay() {
		// TODO method stub
	}

	/**
	 * Checks if the user has enough money to spend without debt.
	 * @param moneyNeeded
	 * @return no debt incurred
	 * @pre moneyNeeded >= 0
	 * @invariant money
	 */
	
	public int getWeight(){
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
	
	/**
	 * Checks if added weight would overload wagon
	 * @param weight to be added
	 * @return true if wagon would be ok, false if overweight.
	 */
	public boolean checkWeight(int weight){
		if (wagonWeight + weight > MAXWEIGHT){
			return false;
		}else {
			return true;
		}
		
	}
	
	public static int getItemWeight(String item){
		
		
		if(item.equals(BULLETS)){
			return 1;
		}else if(item.equals(FOOD)){
			return 5;
		}else if(item.equals(CLOTHES)){
			return 5;
		}
		return 0;
	}
	
	public void add(Part part) throws UserInputException{
		spareParts.add(part);
		// TODO Check the wagon weight everytime we add a part
		// TODO run repair function to move spareParts -> activeParts as appropriate
	}

	public void add(String item, int quantity) throws UserInputException{
		// TODO Implement weights using getItemWeight!
		if(item.equals(OXEN)){
			oxen += quantity;
		}else if(item.equals(BULLETS)){
			bullets += quantity;
		}else if(item.equals(FOOD)){
			food += quantity;
		}else if(item.equals(CLOTHES)){
			clothes += quantity;
		}
	}
	
	/**
	 * Repairs the wagon with available parts
	 * @return Wagon fully repaired
	 */
	public boolean repair(){
		
		//TODO if parts in activeParts are broken, try moving parts from spare.
		return true;
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

}

