package com.kelsonprime.oregontrail.controller;

import com.kelsonprime.oregontrail.model.Occupation;

public class Player extends Companion {
	private Occupation occupation;

	public Player(String name, Occupation occupation) {
		super(name);
		this.occupation = occupation;
	}

	Occupation getOccupation() {
		return occupation;
	}

	int startingMoney() {
		return occupation.getStartingMoney();
	}

}