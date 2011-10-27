package com.kelsonprime.oregontrail.model;

public enum Item {
	BULLETS("Bullets", 1), FOOD("Food", 1), CLOTHES("Clothes", 1), OXEN("Oxen", 0);
	private int weight;
	private String name;
	private Item(String name, int weight){
		this.name = name;
		this.weight = weight;
	}
	
	public String toString(){
		return this.name;
	}
	public int getWeight(){
		return this.weight;
	}
}
