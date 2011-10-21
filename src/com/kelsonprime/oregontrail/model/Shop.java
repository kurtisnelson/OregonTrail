package com.kelsonprime.oregontrail.model;

import java.util.LinkedList;
import java.util.List;

import com.kelsonprime.oregontrail.controller.UserInputException;

/**
 * Represent a <code>Location</code> that is a Shop
 * @author Kurt Nelson
 * @version .1
 * @see com.kelsonprime.oregontrail.gui.ShopScreen
 */
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
	 * Class constructor with default prices and no supply distance price scaling.
	 * @param name How to label the store in UI
	 */
	public Shop(String name){
		this(name, 0);
	}
	
	/**
	 * Class constructor with default prices
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
	 * @param supplyDistance How far the store is from it's "supply"
	 * @pre supplyDistance >= 1
	 * @invariant oxenPrice
	 * @post foodPrice >= $pre(int, foodPrice) && clothesPrice >= $pre(int, clothesPrice)
	 */
	private void scalePrices(int supplyDistance){
		double multiplier = (supplyDistance * PRICE_RATIO) + 1;
		foodPrice *= multiplier;
		clothesPrice *= multiplier;
		bulletPrice *= multiplier;
		wheelPrice *= multiplier;
		tonguePrice *= multiplier;
		axlePrice *= multiplier;
	}

	/**
	 * Sell new <code>Part</code>s to <code>Wagon</code>. Puts <code>Part</code>s in a List and dumps off to helper method.
	 * @param w Purchaser
	 * @param axles Axle quantity
	 * @param wheels Wheel quantity
	 * @param tongues Tongue quantity
	 * @throws UserInputException If <code>Wagon</code> will become overweight or not enough money is available.
	 * @post w.getMoney() < $pre(int, w.getMoney())
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
		while(tongues > 0){
			parts.add(new Tongue());
			tongues--;
		}
		this.sellToWagon(w, parts);
	}
	
	/**
	 * Helper method used to sell <code>Part</code>s to <code>Wagon</code>.
	 * @param w Purchaser
	 * @param parts Order
	 * @throws UserInputException If <code>Wagon</code> will become overweight or not enough money is available.
	 * @post w.getMoney() < $pre(int, w.getMoney())
	 */
	public void sellToWagon(Wagon w, List<Part> parts) throws UserInputException{
		
		java.util.Iterator<Part> iter = parts.iterator();
		Part temp;
		while (iter.hasNext()) {
			temp = iter.next();
			if (w.checkMoney(getPrice(temp.toString()))){
				w.add(temp.toString(), 1);
				w.changeMoney((-1)*getPrice(temp.toString()));
			}
			else {
				throw new UserInputException("Not Enough money to buy " + temp.toString());
			}
		}
		w.add(parts);
	}
	

	/**
	 * Sell item to <code>Wagon</code>.
	 * @param w Purchaser
	 * @param item <code>String</code> constant in <code>Wagon</code> that should be purchased.
	 * @param quantity Item quantity
	 * @throws UserInputException If <code>Wagon</code> will become overweight or not enough money is available.
	 * @pre item == Wagon.FOOD || item == Wagon.CLOTHES || item == Wagon.BULLETS || item == Wagon.OXEN
	 * @post w.getMoney() < $pre(int, w.getMoney())
	 */
	public void sellToWagon(Wagon w, String item, int quantity) throws UserInputException{

		if (w.checkMoney(getPrice(item) * quantity)) {
			w.add(item, quantity);
			w.changeMoney(getPrice(item) * quantity * (-1));
		}
		else {
			throw new UserInputException("Not enough money to buy " + item);
		}
	}

	/**
	 * @return Price of oxen at this store
	 */
	public int oxenPrice() {
		return oxenPrice;
	}

	/**
	 * @return Price of food at this store
	 */
	public int foodPrice() {
		return foodPrice;
	}

	/**
	 * @return Price of clothes at this store
	 */
	public int clothesPrice() {
		return clothesPrice;
	}

	/**
	 * @return Price of bullets at this store
	 */
	public int bulletPrice() {
		return bulletPrice;
	}

	/**
	 * @return Price of wheels at this store
	 */
	public int wheelPrice() {
		return wheelPrice;
	}

	/**
	 * @return Price of axles at this store
	 */
	public int axlePrice() {
		return axlePrice;
	}

	/**
	 * @return Price of tongues at this store
	 */
	public int tonguePrice() {
		return tonguePrice;
	}

	/**
	 * local helper method that takes the string rep of an object and gives back the price
	 * @param item thing we want the price of
	 * @return the price of item
	 */
	private int getPrice (String item) {
		
		if (item.equals(Wagon.AXLE)){
			return this.axlePrice();
		}
		else if (item.equals(Wagon.BULLETS)){
			return this.bulletPrice();
		}
		else if (item.equals(Wagon.CLOTHES)){
			return this.clothesPrice();
		}
		else if (item.equals(Wagon.FOOD)){
			return this.foodPrice();
		}
		else if (item.equals(Wagon.OXEN)){
			return this.oxenPrice();
		}
		else if (item.equals(Wagon.TONGUE)){
			return this.tonguePrice();
		}
		else if (item.equals(Wagon.WHEEL)){
			return this.wheelPrice();
		}
		return 0;
	}
}
