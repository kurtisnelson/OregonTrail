package com.kelsonprime.oregontrail.model;

/**
 * Ration model
 * @author Kurt
 *
 * @version $Revision: 1.0 $
 */
public enum Ration {
	BARE(1, "Bare"), MEAGER(1, "Meager"), NORMAL(2, "Normal"), WELLFED(3, "Wellfed");
	private int portion;

	private String name;

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
