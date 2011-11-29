package com.kelsonprime.oregontrail.model;

/**
 * Represent a carpenter
 * @author Kurt
 * @version 1
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
