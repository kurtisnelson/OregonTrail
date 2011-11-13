package com.kelsonprime.oregontrail.model;

/**
 * Represent a Banker
 */
public final class Banker extends Occupation {
	private static final long serialVersionUID = 7567352191869501069L;

	/**
	 * Get name
	 * @return String
	 */
	public static String getStaticLabel(){
		return "Banker";
	}
	
	/**
	 * Get starting money
	 * @return int
	 */
	public static int getStaticMoney(){
		return 3000;
	}
	
	/**
	 * Get description
	 * @return String
	 */
	public static String getStaticDescription(){
		return "Starts with extra money";
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
