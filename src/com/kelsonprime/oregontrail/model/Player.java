package com.kelsonprime.oregontrail.model;


public class Player extends Companion {
	private Occupation occupation;

	public Player(String name, Occupation occupation) {
		super(name);
		this.occupation = occupation;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public int startingMoney() {
		return occupation.getStartingMoney();
	}

}