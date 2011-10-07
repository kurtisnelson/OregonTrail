package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.PassDay;

public abstract class Part implements PassDay {
	protected int health;
	protected final double WEARRATIO = .01;

	/**
	 * 
	 */
	public Part(int health) {
		this.health = health;
	}

	@Override
	public void passDay(Game game) {
		health = (int) (health - (health * .01));
		// TODO account for pace with game.getPace()
	}
}