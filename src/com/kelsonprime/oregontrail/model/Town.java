package com.kelsonprime.oregontrail.model;


public class Town extends Location {
	private Shop shop;

	public Town(String name) {
		super(name);
	}
	
	public void addShop(Shop shop) {
		this.shop = shop;
	}

}