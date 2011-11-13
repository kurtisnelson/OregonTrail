package com.kelsonprime.oregontrail.model;


/**
 */
public class Player extends Companion {
	private static final long serialVersionUID = -2572176052523635587L;
	private Occupation occupation;

	/**
	 * Constructor for Player.
	 * @param name String
	 * @param occupation Occupation
	 */
	public Player(String name, Occupation occupation) {
		super(name);
		this.occupation = occupation;
	}

	/**
	 * Method getOccupation.
	 * @return Occupation
	 */
	public Occupation getOccupation() {
		return occupation;
	}

	/**
	 * Method startingMoney.
	 * @return int
	 */
	public int startingMoney() {
		return occupation.getMoney();
	}

}