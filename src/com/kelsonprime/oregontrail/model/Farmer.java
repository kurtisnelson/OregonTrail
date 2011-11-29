package com.kelsonprime.oregontrail.model;

/**
 */
public final class Farmer extends Occupation {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 7392693973481195514L;

	/**
	 * Description of the Occupation
	 */
	public static final String DESCRIPTION = "Can forage for food and takes care of oxen";
	
	/**
	 * Starting money
	 */
	public static final int START_MONEY = 1500;

	/**
	 * Label of this Occupation
	 */
	public static final String LABEL = "Farmer";

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
