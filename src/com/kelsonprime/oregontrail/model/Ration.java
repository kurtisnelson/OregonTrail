package com.kelsonprime.oregontrail.model;

/**
 * Ration model
 * @author Kurt
 *
 * @version $Revision: 1.0 $
 */
public enum Ration {
	BARE(0, "Bare"), MEAGER(1, "Meager"), NORMAL(2, "Normal"), WELLFED(3, "Wellfed");
	
	/**
	 * The amount of food a ration consumes
	 */
	private final int portion;

	/**
	 * The user seen name
	 */
	private final String name;

	/**
	 * What is considered a health maintaining portion
	 */
	public static final int PROPER_PORTION = 2;
	
	/**
	 * Constructor for Ration.
	 * @param p int
	 * @param name String
	 */
	private Ration(int p, String name){
		portion = p;
		this.name = name;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	public String toString(){
		return name;
	}

	/**
	 * Method getPortion.
	 * @return int
	 */
	public int getPortion(){
		return portion;
	}
}
