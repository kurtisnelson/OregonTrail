package com.kelsonprime.oregontrail.model;


/**
 */
public class Town extends Location {
	private static final long serialVersionUID = -9072887803166850420L;
	private Shop shop;
	/**
	 * Constructor for Town.
	 * @param name String
	 * @param position int
	 */
	public Town(String name, int position) {
		super(name, position);
		this.shop = null;
	}
	/**
	 * Constructor for Town.
	 * @param name String
	 * @param position int
	 * @param shop Shop
	 */
	public Town(String name, int position, Shop shop){
		super(name, position);
		this.shop = shop;
	}
	/**
	 * Method getShop.
	 * @return Shop
	 */
	public Shop getShop(){
		return shop;
	}
}