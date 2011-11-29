package com.kelsonprime.oregontrail.model;

/**
 * Represent a wagon tongue
 * 
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class Tongue extends Part {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 8766537377409751997L;
	/**
	 * Default health of this part (value is 125)
	 */
	private static final int DEFAULT_HEALTH = 125;
	/**
	 * Default weight of this part (value is 5)
	 */
	private static final int DEFAULT_WEIGHT = 5;

	/**
	 * Create a tongue with specified health
	 * 
	 * @param health
	 *            int
	 */
	public Tongue(int health) {
		super(health);
	}

	/**
	 * Create a tongue with full health
	 */
	public Tongue() {
		this(DEFAULT_HEALTH);
	}

	/**
	 * Get weight of a tongue
	 * 
	 * @return int Tongue weight
	 */
	public static int getWeight() {
		return DEFAULT_WEIGHT;
	}

	/**
	 * Standard toString
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Tongue at " + this.health;
	}

	/**
	 * Standard compareTo
	 * 
	 * @param o
	 *            Object
	 * @return int
	 * @throws ClassCastException
	 */
	@Override
	public int compareTo(Object o) throws ClassCastException {
		Tongue ot = (Tongue) o;
		return ot.health - this.health;
	}

	/**
	 * Standard equals.
	 * 
	 * @param o
	 *            Object
	 * @return boolean
	 * @see com.kelsonprime.oregontrail.model.Time#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o instanceof Tongue) {
			Tongue tongue = (Tongue) o;
			if (tongue.getHealth() == this.getHealth())
				return true;
		}
		return false;
	}

	/**
	 * Standard hashCode.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}