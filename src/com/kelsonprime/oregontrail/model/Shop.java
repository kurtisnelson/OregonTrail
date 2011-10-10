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
		scalePrices(supplyDistance);
	}

	public void scalePrices(int supplyDistance){
		// TODO adjust prices based on PRICE_RATIO and supplyDistance.
	}
	
	public void sellItem() {
		// TODO method stub
	}

	public int getOxenPrice() {
		return oxenPrice;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public int getClothesPrice() {
		return clothesPrice;
	}

	public int getBulletPrice() {
		return bulletPrice;
	}

	public int getWheelPrice() {
		return wheelPrice;
	}

	public int getAxlePrice() {
		return axlePrice;
	}

	public int getTonguePrice() {
		return tonguePrice;
	}

}