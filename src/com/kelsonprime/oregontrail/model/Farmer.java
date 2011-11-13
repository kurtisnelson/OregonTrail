package com.kelsonprime.oregontrail.model;

/**
 */
public final class Farmer extends Occupation {
	private static final long serialVersionUID = -4579907147578377999L;

	/**
	 * Method getStaticLabel.
	 * @return String
	 */
	public static String getStaticLabel(){
		return "Farmer";
	}
	
	/**
	 * Method getStaticMoney.
	 * @return int
	 */
	public static int getStaticMoney(){
		return 1500;
	}
	
	/**
	 * Method getStaticDescription.
	 * @return String
	 */
	public static String getStaticDescription(){
		return "Takes better care of oxen, and can find food along the way";
	}
	
	/**
	 * Method getMoney.
	 * @return int
	 */
	@Override
	public int getMoney() {
		return getStaticMoney();
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	@Override
	public String getDescription() {
		return getStaticDescription();
	}

	/**
	 * Method getLabel.
	 * @return String
	 */
	@Override
	public String getLabel() {
		return getStaticLabel();
	}
}
