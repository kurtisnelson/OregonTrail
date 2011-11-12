package com.kelsonprime.oregontrail.model;


public class Town extends Location {
	private static final long serialVersionUID = -9072887803166850420L;
	private Shop shop;
	public Town(String name, int position) {
		super(name, position);
		this.shop = null;
	}
	public Town(String name, int position, Shop shop){
		super(name, position);
		this.shop = shop;
	}
	public Shop getShop(){
		return shop;
	}
}