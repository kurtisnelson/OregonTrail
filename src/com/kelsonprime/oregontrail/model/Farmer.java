package com.kelsonprime.oregontrail.model;

/**
 * Represent a farmer
 * @author Kurt
 * @version 1
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

	/**
	 * Provide label
	 * @return label
	 */
	@Override
	public String toString() {
		return LABEL;
	}

	/**
	 * Starting money
	 * @return money
	 */
	@Override
	public int getStartingMoney() {
		return START_MONEY;
	}

	/**
	 * Provide description
	 * @return description
	 */
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
