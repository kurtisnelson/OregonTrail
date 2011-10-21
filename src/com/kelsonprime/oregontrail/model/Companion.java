package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Game;

public class Companion {

	protected int health; // Percent
	protected String name;
	protected boolean live;
	protected String sickness;

	public Companion(String name) {
		this.name = name;
		live = true;
		sickness = "";
		health = 100;
	}
	
	public boolean isAlive(){
		return live;
	}

	/**
	 * 
	 * @param game
	 */
	void passDay(Game game) {
		// TODO method stub
	}

}