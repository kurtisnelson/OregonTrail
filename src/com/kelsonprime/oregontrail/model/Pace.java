package com.kelsonprime.oregontrail.model;

/**
 * Enumerates type of paces (speeds)
 * @author Aman
 *
 */
public enum Pace {
	STOPPED(0,"Stopped"), LEISURELY(1, "Leisurely"), STEADY(2, "Steady"), GRUELING(3, "Grueling");
	private int rate;
	private String name;
	private Pace(int rate, String name){
		this.rate = rate;
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
	public int getRate(){
		return rate;
	}
}
