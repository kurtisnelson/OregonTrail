package com.kelsonprime.oregontrail.controller;

import java.util.List;

import com.kelsonprime.oregontrail.gui.Listener;
import com.kelsonprime.oregontrail.gui.OregonTrail;
import com.kelsonprime.oregontrail.model.Location;
import com.kelsonprime.oregontrail.model.Part;
import com.kelsonprime.oregontrail.model.Wagon;

/**
 * This class holds information about a game. 
 * @author Aman Jain
 *
 */
public class Game implements Time {

	public Listener reciever;
	private Wagon wagon;
	private Map map;
	private int days;
	private Pace pace;
	private Ration ration;

	/**
	 * Constructs Game object and initializes all variables like map, wagon etc
	 */
	public Game(Wagon wagon) {
		this.reciever = new Listener();
		this.days = 0;
		this.pace = Pace.STEADY;
		this.ration = Ration.NORMAL;
		this.wagon = wagon;
		this.map = new Map();
	}
	
	/**
	 * Gets current location on map
	 * @return location
	 */
	public Location currentLocation(){
		return map.currentLocation();
	}

	/**
	 * Number of days since game start
	 * 
	 * @return days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * Current pace
	 * 
	 * @return pace
	 */
	public Pace getPace() {
		return pace;
	}
	
	/**
	 * Sets the pace of the game
	 * @param pace
	 */
	public void setPace(Pace pace) {
		this.pace = pace;
	}

	/**
	 * Accepts a trade item
	 * @param item
	 */
	public void acceptTrade(Object item) {
		// TODO method stub
	}

	/**
	 * Does bookkeeping for hunting
	 */
	public void hunt() {
		// TODO method stub
	}

	/**
	 * Does the bookkeeping for rest
	 */
	public void rest() {
		// TODO method stub
	}

	/**
	 * Gets the ration left
	 * @return ration
	 */
	public Ration getRation() {
		return ration;
	}

	/**
	 * Sets the ration
	 * @param ration
	 */
	public void setRation(Ration ration) {
		this.ration = ration;
	}

	public boolean isReady() {
		// TODO method stub
		return false;
	}

	/**
	 * Offers a part to trade
	 * @param need What <code>Part</code> the player needs
	 * @param quantity How many of need
	 * @return part A list of parts they would give to get need
	 */
	public List<Part> offerTrade(Part need, int quantity) {
		// TODO method stub
		return null;
	}
	
	/**
	 * Gets the wagon
	 * @return wagon
	 */
	public Wagon getWagon(){
		return wagon;
	}
	
	/**
	 * Move from location
	 */
	public void leaveLocation(){
		map.travel(1);
	}
	
	/**
	 * Gets the current map
	 * @return map
	 */
	public Map getMap(){
		return map;
	}

	/**
	 * Sets the owner of the game
	 */
	public void setOwner(OregonTrail owner){
		reciever.setOwner(owner);
	}

	@Override
	public void nextDay(Game game) {
		wagon.nextDay(this);
		map.nextDay(this);
		days++;
	}
}
