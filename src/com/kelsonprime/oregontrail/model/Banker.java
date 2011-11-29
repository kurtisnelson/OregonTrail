package com.kelsonprime.oregontrail.model;

/**
 * Represent a Banker
 * @author Kurt Nelson
 * @version $Revision: 1.0 $
 */
public final class Banker extends Occupation {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 7567352191869501069L;
	
	/**
	 * Description of the Occupation
	 */
	public static final String DESCRIPTION = "Starts with extra money";
	
	/**
	 * Starting money
	 */
	public static final int START_MONEY=3000;

	/**
	 * Label of this Occupation
	 */
	public static final String LABEL = "Banker";

	@Override
	public String toString() {
		return LABEL;
	}

	@Override
	public int getStartingMoney() {
		return START_MONEY;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
