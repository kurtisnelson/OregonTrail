// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.preferInterfacesToAbstractClasses
package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

/**
 * Represent a Part of the wagon
 * @author Kurt Nelson
 * @version 1
 */
public abstract class Part implements Time, Comparable<Object>, Serializable {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 735490215309106832L;

	/**
	 * Default weight of a part
	 */
	public static final int DEFAULT_WEIGHT = 5;

	/**
	 * Default health of a part
	 */
	public static final int DEFAULT_HEALTH = 100;
	
	/**
	 * Health of a part
	 */
	protected int health;
	
	/**
	 * Initialize Part with default health
	 */
	public Part(){
		this.health = DEFAULT_HEALTH;
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
	 * @see com.kelsonprime.oregontrail.model.Time#nextDay(Game)
	 */
	@Override
	public void nextDay(Game game) {
		health = (health - game.getPace().getRate());
	}
	
	/**
	 * Get how much a type of part weighs
	 * @param p Type of <code>Part</code>
	
	 * @return Weight */
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
	
	/**
	 * Method isReady.
	 * @return boolean
	 * @see com.kelsonprime.oregontrail.model.Time#isReady()
	 */
	@Override
	public boolean isReady() {
		return health > 0;
	}

	/**
	 * Get health of this part
	
	 * @return health of part */
	public int getHealth(){
		return health;
	}
	
	/**
	 * Method equals.
	 * @param o Object
	 * @return boolean
	 */
	@Override
	public abstract boolean equals(Object o); // $codepro.audit.disable checkTypeInEquals, overridingNonAbstractMethod
	
	/**
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode(){
		return this.toString().hashCode() ^ getHealth();
	}
}