package com.kelsonprime.oregontrail.controller;

import com.kelsonprime.oregontrail.gui.Listener;
import com.kelsonprime.oregontrail.gui.OregonTrail;
import com.kelsonprime.oregontrail.model.Location;
import com.kelsonprime.oregontrail.model.Part;
import com.kelsonprime.oregontrail.model.Wagon;

public class Game implements Time {

	public Listener reciever;
	private Wagon wagon;
	private Map map;
	private int days;
	private Pace pace;
	private Ration ration;

	public Game(Wagon wagon) {
		this.reciever = new Listener();
		this.days = 0;
		this.pace = Pace.STEADY;
		this.ration = Ration.NORMAL;
		this.wagon = wagon;
		this.map = new Map();
	}
	
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
	 * 
	 * @param item
	 */
	public void acceptTrade(Object item) {
		// TODO method stub
	}

	public void hunt() {
		// TODO method stub
	}

	public void rest() {
		// TODO method stub
	}

	/**
	 * 
	 * @param pace
	 */
	public void setPace(Pace pace) {
		this.pace = pace;
	}

	public Ration getRation() {
		return ration;
	}

	/**
	 * 
	 * @param ration
	 */
	public void setRation(Ration ration) {
		this.ration = ration;
	}

	public boolean isReady() {
		// TODO method stub
		return false;
	}

	public Part offerTrade(Part need, int quantity) {
		// TODO method stub
		return null;
	}
	
	public Wagon getWagon(){
		return wagon;
	}
	
	public void leaveLocation(){
		map.travel(1);
	}
	
	public Map getMap(){
		return map;
	}

	public void setOwner(OregonTrail owner){
		reciever.setOwner(owner);
	}

	@Override
	public void nextDay() {
		// TODO nextDay
		wagon.nextDay();
	}
}
