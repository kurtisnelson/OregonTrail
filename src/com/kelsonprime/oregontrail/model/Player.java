package com.kelsonprime.oregontrail.model;


/**
 * Represent a player
 * @author Kurt
 * @version $Revision: 1.0 $
 */
public class Player extends Companion {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -2572176052523635587L;

	/**
	 * The player's occupation
	 */
	private final Occupation occupation;

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
	 * Get occupation
	 * @return Occupation
	 */
	public Occupation getOccupation() {
		return occupation;
	}

	/**
	 * Get starting money
	 * @return int
	 */
	public int startingMoney() {
		return occupation.getStartingMoney();
	}

}