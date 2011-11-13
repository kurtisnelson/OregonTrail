package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

/**
 */
public abstract class Occupation implements Serializable {
	private static final long serialVersionUID = -6040773823566650272L;
	
	/**
	 * Method getOccupations.
	 * @return Class<?>[]
	 */
	public static Class<?>[] getOccupations(){
		Class<?>[] occs = new Class[3];
		occs[0] = Banker.class;
		occs[1] = Carpenter.class;
		occs[2] = Farmer.class;
		return occs;
	}
	
	public Occupation(){
		
	}
	
	/**
	 * Method getMoney.
	 * @return int
	 */
	public abstract int getMoney();
	/**
	 * Method getDescription.
	 * @return String
	 */
	public abstract String getDescription();
	/**
	 * Method getLabel.
	 * @return String
	 */
	public abstract String getLabel();
}