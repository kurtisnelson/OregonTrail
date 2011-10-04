package com.kelsonprime.oregontrail.logic;

public abstract class Occupation {
	private int startingMoney;
	private String name;
	public String toString(){
		return name;
	}
	public int startingMoney(){
		return startingMoney;
	}
}