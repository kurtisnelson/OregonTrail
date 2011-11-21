package com.kelsonprime.oregontrail.model;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kelsonprime.oregontrail.controller.UserInputException;

/**
 * Represent a <code>Location</code> that is a Shop
 * 
 * @author Kurt Nelson
 * @version .1
 * @see com.kelsonprime.oregontrail.gui.ShopScreen
 */
public class Shop extends Location {
	private static final long serialVersionUID = 2474893524066364591L;
	private final static Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final double PRICE_RATIO = .001;
	private int oxenPrice;
	private int foodPrice;
	private int clothesPrice;
	private int bulletPrice;
	private int wheelPrice;
	private int tonguePrice;
	private int axlePrice;

	/**
	 * Class constructor with default prices and no supply distance price
	 * scaling.
	 * 
	 * @param name
	 *            How to label the store in UI
	 * @param position
	 *            int
	 */
	public Shop(String name, int position) {
		this(name, position, 0);
	}

	/**
	 * Class constructor with default prices
	 * 
	 * @param name
	 *            How to label the store in UI
	 * @param supplyDistance
	 *            How far the store is from it's "supply"
	 * @post name != null
	 * @param position
	 *            int
	 */
	public Shop(String name, int position, int supplyDistance) {
		super(name, position);
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
	 * 
	 * @param supplyDistance
	 *            How far the store is from it's "supply"
	 * @pre supplyDistance >= 1
	 * 
	 * @post foodPrice >= $pre(int, foodPrice) && clothesPrice >= $pre(int,
	 *       clothesPrice)
	 */
	private void scalePrices(int supplyDistance) {
		double multiplier = (supplyDistance * PRICE_RATIO) + 1;
		foodPrice *= multiplier;
		clothesPrice *= multiplier;
		bulletPrice *= multiplier;
		wheelPrice *= multiplier;
		tonguePrice *= multiplier;
		axlePrice *= multiplier;
	}

	/**
	 * Sell new <code>Part</code>s to <code>Wagon</code>. Puts <code>Part</code>
	 * s in a List and dumps off to helper method.
	 * 
	 * @param w
	 *            Purchaser
	 * @param axles
	 *            Axle quantity
	 * @param wheels
	 *            Wheel quantity
	 * @param tongues
	 *            Tongue quantity
	 * 
	 * @post w.getMoney() < $pre(int, w.getMoney())
	 * @throws UserInputException
	 *             If <code>Wagon</code> will become overweight or not enough
	 *             money is available.
	 */
	public void sellToWagon(Wagon w, int axles, int wheels, int tongues)
			throws UserInputException {
		List<Part> parts = new LinkedList<Part>();
		while (axles > 0) {
			parts.add(new Axle());
			axles--;
		}
		while (wheels > 0) {
			parts.add(new Wheel());
			wheels--;
		}
		while (tongues > 0) {
			parts.add(new Tongue());
			tongues--;
		}
		this.sellToWagon(w, parts);
	}

	/**
	 * Helper method used to sell <code>Part</code>s to <code>Wagon</code>.
	 * 
	 * @param w
	 *            Purchaser
	 * @param parts
	 *            Order
	 * 
	 * @post w.getMoney() < $pre(int, w.getMoney())
	 * @throws UserInputException
	 *             If <code>Wagon</code> will become overweight or not enough
	 *             money is available.
	 */
	public void sellToWagon(Wagon w, List<Part> parts)
			throws UserInputException {
		int weight = 0;
		int total = 0;
		for (Part part : parts) {
			if (w.checkWeight(weight)) {
				weight += Part.getWeight(part);
			} else {
				throw new UserInputException("Not enough room to buy " + part);
			}
			if (w.checkMoney(total * -1)) {
				total += getPrice(part);
			} else {
				throw new UserInputException("Not enough money to buy " + part);
			}
		}
		try {
			for (Part part : parts) {
				w.add(part);
			}
			w.changeMoney((-1) * total);
		} catch (UserInputException e) {
			LOGGER.log(Level.SEVERE, "Game ruined.", e);
			throw new RuntimeException("Current game state trashed");
		}
	}

	/**
	 * Sell Item to <code>Wagon</code>.
	 * 
	 * @param w
	 *            Purchaser
	 * @param item
	 *            <code>Item</code> that should be purchased.
	 * @param quantity
	 *            Item quantity
	 * 
	 * @post w.getMoney() < $pre(int, w.getMoney())
	 * @throws UserInputException
	 *             If <code>Wagon</code> will become overweight or not enough
	 *             money is available.
	 */
	public void sellToWagon(Wagon w, Item item, int quantity)
			throws UserInputException {
		if (!w.checkWeight(quantity * item.getWeight())) {
			throw new UserInputException("Not enough space for " + quantity
					+ " " + item);
		}
		if (!w.checkMoney(quantity * getPrice(item))) {
			throw new UserInputException("Not enough money for " + quantity
					+ " " + item);
		}
		try {
			w.add(item, quantity);
			w.changeMoney(getPrice(item) * quantity * (-1));
		} catch (UserInputException e) {
			LOGGER.log(Level.SEVERE, "Game ruined", e);
			throw new RuntimeException("Current game state trashed");
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
	 * Gets the price of an <code>Item</code> at this store.
	 * 
	 * @param item Item we want the price of
	 * @return the price of Item
	 */
	private int getPrice(Item item) {
		switch (item) {
		case BULLETS:
			return this.bulletPrice();
		case CLOTHES:
			return this.clothesPrice();
		case FOOD:
			return this.foodPrice();
		case OXEN:
			return this.oxenPrice();
		}
		return 0;
	}

	/**
	 * Get the price of a part at this store
	 * 
	 * @param item Part
	 * @return int
	 */
	private int getPrice(Part item) {
		if (item instanceof Axle) {
			return axlePrice;
		} else if (item instanceof Tongue) {
			return tonguePrice;
		} else if (item instanceof Wheel) {
			return wheelPrice;
		}
		return 0;
	}
	
	public String getSoundFileName() {
		return "cc-start.wav";
	}
}
