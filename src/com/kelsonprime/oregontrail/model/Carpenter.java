package com.kelsonprime.oregontrail.model;

/**
 * Represent a carpenter
 */
public final class Carpenter extends Occupation {
	private static final long serialVersionUID = -8843042214187651692L;

	/**
	 * Get label
	 * @return String
	 */
	public static String getStaticLabel(){
		return "Carpenter";
	}
	
	/**
	 * Get starting money
	 * @return int
	 */
	public static int getStaticMoney(){
		return 2000;
	}
	
	/**
	 * Get description
	 * @return String
	 */
	public static String getStaticDescription(){
		return "Can fix wagon parts when they break.";
	}

	@Override
	public int getMoney() {
		return getStaticMoney();
	}

	@Override
	public String getDescription() {
		return getStaticDescription();
	}

	@Override
	public String getLabel() {
		return getStaticLabel();
	}
}
