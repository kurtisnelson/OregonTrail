package com.kelsonprime.oregontrail.model;

/**
 * Represent a town
 */
public class Town extends Location {
	private static final long serialVersionUID = -9072887803166850420L;
	private Shop shop;

	/**
	 * Create a town
	 * 
	 * @param name
	 *            String
	 * @param position
	 *            int distance from start
	 */
	public Town(String name, int position) {
		super(name, position);
		this.shop = null;
	}

	/**
	 * Constructor for Town.
	 * 
	 * @param name
	 *            String
	 * @param position
	 *            int distance from start
	 * @param shop
	 *            Shop
	 */
	public Town(String name, int position, Shop shop) {
		super(name, position);
		this.shop = shop;
	}

	/**
	 * Get the shop at this town
	 * 
	 * @return Shop
	 */
	public Shop getShop() {
		return shop;
	}
	
	public String getSoundFileName() {
		return "thanks.wav";
	}
	
}