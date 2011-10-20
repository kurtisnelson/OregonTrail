package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.PassNight;

public abstract class Part implements PassNight {
	protected int health;
	protected final double WEARRATIO = .01;
	
	public Part(){
		this.health = 100;
	}
	
	public Part(int health) {
		this.health = health;
	}

	@Override
	public void passNight(Game game) {
		health = (int) (health - (health * .01));
		// TODO account for pace with game.getPace()
	}
}