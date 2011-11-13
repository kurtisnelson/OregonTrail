package com.kelsonprime.oregontrail.model;

/**
 * Enumerates type of paces (speeds)
 * @author Aman
 *
 * @version $Revision: 1.0 $
 */
public enum Pace {
	STOPPED(0,"Stopped"), LEISURELY(1, "Leisurely"), STEADY(2, "Steady"), GRUELING(3, "Grueling");
	private int rate;
	private String name;
	/**
	 * Constructor for Pace.
	 * @param rate int
	 * @param name String
	 */
	private Pace(int rate, String name){
		this.rate = rate;
		this.name = name;
	}
	
	/**
	 * Method toString.
	 * @return String
	 */
	public String toString(){
		return name;
	}
	
	/**
	 * Method getRate.
	 * @return int
	 */
	public int getRate(){
		return rate;
	}
}
