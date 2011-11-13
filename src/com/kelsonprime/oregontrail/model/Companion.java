package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

public class Companion implements Time, Serializable{
	private static final long serialVersionUID = -7906565976511200668L;
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
	public void nextDay(Game game) {
		// TODO Auto-generated method stub
		health-=(4-game.getRation().getPortion());
		if (sickness != ""){
			health -=5;
		}
		if (health<0){
			health = 0;
		}
	}

}