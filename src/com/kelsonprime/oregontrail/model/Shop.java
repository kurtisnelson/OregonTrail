package com.kelsonprime.oregontrail.model;

import java.util.LinkedList;
import java.util.List;

import com.kelsonprime.oregontrail.controller.UserInputException;

public class Shop extends Location {
	private static final double PRICE_RATIO = .001;
	private int oxenPrice;
	private int foodPrice;
	private int clothesPrice;
	private int bulletPrice;
	private int wheelPrice;
	private int tonguePrice;
	private int axlePrice;

	/**
	 * Setup a shop with default prices and no supply distance price scaling.
	 * @param name How to label the store in UI
	 */
	public Shop(String name){
		this(name, 0);
	}
	
	/**
	 * Setup a shop with default prices
	 * @param name How to label the store in UI
	 * @param supplyDistance How far the store is from it's "supply"
	 * @post name != null
	 */
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
	 * @pre supplyDistance >= 1
	 * @invariant oxenPrice
	 * @post foodPrice >= $pre(int, foodPrice) && clothesPrice >= $pre(int, clothesPrice)
	 */
	public void scalePrices(int supplyDistance){
		// TODO adjust prices based on PRICE_RATIO and supplyDistance.
		double multiplier = (supplyDistance * PRICE_RATIO) + 1;
		foodPrice *= multiplier;
		clothesPrice *= multiplier;
		bulletPrice *= multiplier;
		wheelPrice *= multiplier;
		tonguePrice *= multiplier;
		axlePrice *= multiplier;
	}
	
	/**
	 * Sell new Parts to Wagon.
	 * @param w Wagon that is purchasing the items
	 * @param axles Quantity
	 * @param wheels Quantity
	 * @param tongues Quantity
	 * @throws UserInputException if the wagon will become overweight or not enough money is available.
	 */
	public void sellToWagon(Wagon w, int axles, int wheels, int tongues) throws UserInputException{
		List<Part> parts = new LinkedList<Part>();
		while(axles > 0){
			parts.add(new Axle());
			axles--;
		}
		while(wheels > 0){
			parts.add(new Wheel());
			wheels--;
		}
		while(axles > 0){
			parts.add(new Tongue());
			tongues--;
		}
		this.sellToWagon(w, parts);
	}
	
	public void sellToWagon(Wagon w, List<Part> parts) throws UserInputException{
		// TODO implement!
		//w.add(partsSold);	
	}

	public void sellToWagon(Wagon w, String item, int quantity) throws UserInputException{
		// TODO implement!
		//w.add(item, quantitySold);
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
