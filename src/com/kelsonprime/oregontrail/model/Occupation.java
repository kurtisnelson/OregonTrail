package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

/**
 */
public abstract class Occupation implements Serializable {
	private static final long serialVersionUID = -6040773823566650272L;
	
	/**
	 * Get list of occupations
	 * @return Class<?>[]
	 */
	public static Occupation[] getOccupations(){ // $codepro.audit.disable numericLiterals
		Occupation[] occs = new Occupation[3];
		occs[0] = new Banker();
		occs[1] = new Carpenter();
		occs[2] = new Farmer(); 
		return occs;
	}
	
	public abstract String toString();
	
	public abstract int getStartingMoney();
	
	public abstract String getDescription();
}