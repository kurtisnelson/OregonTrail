package com.kelsonprime.oregontrail.model;

/**
 * Represent a carpenter
 */
public final class Carpenter extends Occupation {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -8843042214187651692L;
	
	/**
	 * Description of the Occupation
	 */
	public static final String DESCRIPTION = "Can fix wagon parts when they break";
	
	/**
	 * Starting money
	 */
	public static final int START_MONEY=2000;

	/**
	 * Label of this Occupation
	 */
	public static final String LABEL = "Carpenter";

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
