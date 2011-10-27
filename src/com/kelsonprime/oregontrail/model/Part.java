package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.Time;

public abstract class Part implements Time, Comparable<Object> {
	protected int health;
	protected final double WEARRATIO = .01;
	
	public Part(){
		this.health = 100;
	}
	
	public Part(int health) {
		this.health = health;
	}

	public void nextDay(Game game) {
		health = (int) (health - (health * .01));
		// TODO account for pace with game.getPace()
	}
	
	public static int getWeight(Part p){
		if(p instanceof Wheel){
			return Wheel.getWeight();
		}else if(p instanceof Tongue){
			return Tongue.getWeight();
		}else if(p instanceof Axle){
			return Axle.getWeight();
		}
		return 0;
	}
	
	@Override
	public boolean isReady() {
		return health > 0;
	}

	public int getHealth(){
		return health;
	}
}