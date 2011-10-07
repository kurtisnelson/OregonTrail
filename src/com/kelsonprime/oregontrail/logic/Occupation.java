package com.kelsonprime.oregontrail.logic;

public abstract class Occupation {
	
	protected int startingMoney;
	protected String name;
	protected String description;
	
	public Occupation(){
		
	}
	
	public String toString(){
		return name;
	}
	
	public int getStartingMoney(){
		return startingMoney;
	}
	
	public String getDescription(){
		return this.description;
	}
}