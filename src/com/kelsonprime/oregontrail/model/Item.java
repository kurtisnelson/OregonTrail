package com.kelsonprime.oregontrail.model;

/**
 * Different items.
 * @author kurt
 * @version 1
 */
public enum Item {
	BULLETS("Bullets", 1), FOOD("Food", 1), CLOTHES("Clothes", 1), OXEN("Oxen", 0);
	
	/**
	 * Weight of the item
	 */
	private final int weight;

	/**
	 * User friendly name
	 */
	private final String name;

	/**
	 * Constructor for Item.
	 * @param name String
	 * @param weight int
	 */
	private Item(String name, int weight){
		this.name = name;
		this.weight = weight;
	}
	
	/**
	 * Method toString.
	 * @return String
	 */
	public String toString(){
		return this.name;
	}

	/**
	 * Method getWeight.
	 * @return int
	 */
	public int getWeight(){
		return this.weight;
	}
}
