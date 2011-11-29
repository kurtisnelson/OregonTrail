package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

/**
 * Represent a companion
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class Companion implements Time, Serializable{
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -7906565976511200668L;

	/**
	 * Default health
	 */
	private static final int DEFAULT_HEALTH = 100;
	
	/**
	 * Health penalty per day for being sick
	 */
	private static final int SICK_PENALTY = 5;
	
	/**
	 * Current health
	 */
	protected int health; // Percent

	/**
	 * Name
	 */
	protected String name;

	/**
	 * Are they alive?
	 */
	protected boolean isAlive;

	/**
	 * Description of a sickness
	 */
	protected String sickness;

	/**
	 * Make a companion
	 * @param name String
	 */
	public Companion(String name) {
		this.name = name;
		isAlive = true;
		sickness = "";
		health = DEFAULT_HEALTH;
	}
	
	/**
	 * Can companion travel?
	 * @return boolean
	 * @see com.kelsonprime.oregontrail.model.Time#isReady()
	 */
	public boolean isReady(){
		return isAlive;
	}

	/**
	 * Move in time one day
	 * @param game Game
	 * @see com.kelsonprime.oregontrail.model.Time#nextDay(Game)
	 */
	@Override
	public void nextDay(Game game) {
		health-=(Ration.MAX_PORTION-game.getRation().getPortion());
		if (isSick()){
			health -= SICK_PENALTY;
		}
		if (health<0){
			health = 0;
		}
	}

	/**
	 * Return their name
	 * @return String
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Standard toString
	 * @return Name
	 */
	public String toString(){
		return getName();
	}
	
	/**
	 * Is the companion sick?
	 * @return is sick
	 */
	public boolean isSick(){
		return sickness.length() > 0;
	}
}