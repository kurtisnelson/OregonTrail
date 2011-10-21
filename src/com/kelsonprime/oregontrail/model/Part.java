package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Time;

public abstract class Part implements Time {
	protected int health;
	protected final double WEARRATIO = .01;
	
	public Part(){
		this.health = 100;
	}
	
	public Part(int health) {
		this.health = health;
	}

	public void nextDay() {
		health = (int) (health - (health * .01));
		// TODO account for pace with game.getPace()
	}
	
	@Override
	public boolean isReady() {
		return health > 0;
	}
}