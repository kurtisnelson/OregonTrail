package com.kelsonprime.oregontrail.model;


public class Town extends Location {
	private Shop shop;
	public Town(String name) {
		super(name);
		this.shop = null;
	}
	public Town(String name, Shop shop){
		super(name);
		this.shop = shop;
	}
	public Shop getShop(){
		return shop;
	}
}