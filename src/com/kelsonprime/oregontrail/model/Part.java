package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Time;

public abstract class Part implements Time {
	protected int health;
	protected int weight;
	protected final double WEARRATIO = .01;
	
	public Part(){
		this.health = 100;
		this.weight = 1;
	}
	
	public Part(int health, int weight) {
		this.health = health;
		this.weight = weight;
	}

	public void nextDay() {
		health = (int) (health - (health * .01));
		// TODO account for pace with game.getPace()
	}
	
	@Override
	public boolean isReady() {
		return health > 0;
	}
	
	public int getWeight(){
		return weight;
	}
}