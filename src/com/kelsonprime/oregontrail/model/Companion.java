package com.kelsonprime.oregontrail.model;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.Time;

public class Companion implements Time{

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
	
	public boolean isReady(){
		return isAlive;
	}

	@Override
	public void nextDay() {
		// TODO Auto-generated method stub
		
	}

}