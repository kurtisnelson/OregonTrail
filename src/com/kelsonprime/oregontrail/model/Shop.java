package com.kelsonprime.oregontrail.model;


public class Shop extends Location {
	private static final double PRICE_RATIO = .001;
	private int oxenPrice;
	private int foodPrice;
	private int clothesPrice;
	private int bulletPrice;
	private int wheelPrice;
	private int tonguePrice;
	private int axlePrice;
	private int oxenQuantity;
	private int foodQuantity;
	private int clothesQuantity;
	private int bulletQuantity;
	private int wheelQuantity;
	private int tongueQuantity;
	private int axleQuantity; 

	public Shop(String name){
		this(name, 0);
	}
	public Shop(String name, int supplyDistance) {
		super(name);
		oxenPrice = 20;
		foodPrice = 4;
		clothesPrice = 1;
		bulletPrice = 1;
		wheelPrice = 5;
		tonguePrice = 20;
		axlePrice = 10;
		scalePrices(supplyDistance);
		oxenQuantity = 12;
		foodQuantity = 50;
		clothesQuantity = 20;
		bulletQuantity = 12;
		wheelQuantity = 8;
		tongueQuantity = 9;
		axleQuantity = 7;
	}

	/**
	 * Increase the prices to make up for distance from supply.
	 * @param supplyDistance
	 */
	public void scalePrices(int supplyDistance){
		// TODO adjust prices based on PRICE_RATIO and supplyDistance.
		double multiplier = supplyDistance * PRICE_RATIO;
		bulletPrice *= multiplier;
		wheelPrice *= multiplier;
		tonguePrice *= multiplier;
		axlePrice *= multiplier;
	}
	
	public void sellItem() {
		
		
	}

	public int oxenPrice() {
		return oxenPrice;
	}

	public int foodPrice() {
		return foodPrice;
	}

	public int clothesPrice() {
		return clothesPrice;
	}

	public int bulletPrice() {
		return bulletPrice;
	}

	public int wheelPrice() {
		return wheelPrice;
	}

	public int axlePrice() {
		return axlePrice;
	}

	public int tonguePrice() {
		return tonguePrice;
	}
	public int oxenQuantity() {
		return oxenQuantity;
	}
	public int foodQuantity() {
		return foodQuantity;
	}
	public int clothesQuantity() {
		return clothesQuantity;
	}
	public int bulletQuantity() {
		return bulletQuantity;
	}
	public int wheelQuantity() {
		return wheelQuantity;
	}
	public int axleQuantity() {
		return axleQuantity;
	}
	public int tongueQuantity() {
		return tongueQuantity;
	}
	

}