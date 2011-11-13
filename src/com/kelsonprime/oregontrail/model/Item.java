package com.kelsonprime.oregontrail.model;

/**
 */
public enum Item {
	BULLETS("Bullets", 1), FOOD("Food", 1), CLOTHES("Clothes", 1), OXEN("Oxen", 0);
	private int weight;
	private String name;
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
