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
		// TODO method stub
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

}