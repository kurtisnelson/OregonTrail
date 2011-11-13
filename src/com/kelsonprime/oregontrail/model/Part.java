package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

/**
 * Represent a Part of the wagon
 * @author Kurt Nelson
 * @version 1
 */
public abstract class Part implements Time, Comparable<Object>, Serializable {
	private static final long serialVersionUID = 735490215309106832L;
	
	/**
	 * Health of a part
	 */
	protected int health;
	
	/**
	 * Initialize Part with 100 health
	 */
	public Part(){
		this.health = 100;
	}
	
	/**
	 * Initialize Part
	 * @param health Starting health
	 */
	public Part(int health) {
		this.health = health;
	}

	/**
	 * Apply wear of a day
	 * @param game Game to get pace from
	 */
	public void nextDay(Game game) {
		health = (health - game.getPace().getRate());
	}
	
	/**
	 * Get how much a type of part weighs
	 * @param p Type of <code>Part</code>
	 * @return Weight
	 */
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

	/**
	 * Get health of this part
	 * @return health of part
	 */
	public int getHealth(){
		return health;
	}
	
	@Override
	public abstract boolean equals(Object o);
	
	@Override
	public int hashCode(){
		return this.toString().hashCode() ^ getHealth();
	}
}