package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Game;

public class Companion {

	protected int health; // Percent
	protected String name;
	protected boolean isAlive;
	protected String sickness;

	public Companion(String name) {
		this.name = name;
		isAlive = true;
		sickness = "";
		health = 100;
	}

	/**
	 * 
	 * @param game
	 */
	void passDay(Game game) {
		// TODO method stub
	}

}