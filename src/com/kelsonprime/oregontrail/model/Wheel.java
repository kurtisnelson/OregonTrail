// $codepro.audit.disable hidingInheritedFields
package com.kelsonprime.oregontrail.model;

/**
 * Represent a Wheel
 * 
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class Wheel extends Part {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 6617454331985073863L;

	/**
	 * Default health of this part (value is 80)
	 */
	private static final int DEFAULT_HEALTH = 80;

	/**
	 * Default weight of this part (value is 5)
	 */
	private static final int DEFAULT_WEIGHT = 5;

	/**
	 * Constructor for Wheel.
	 * 
	 * @param health
	 *            int
	 */
	public Wheel(int health) {
		super(health);
	}

	/**
	 * Plain wheel
	 */
	public Wheel() {
		this(DEFAULT_HEALTH);
	}

	/**
	 * Weight of this part
	 * 
	 * @return int
	 */
	public static int getWeight() {
		return DEFAULT_WEIGHT;
	}

	/**
	 * Standard toString.
	 * 
	 * @return String
	 */
	@Override public String toString() {
		return "Wheel";
	}

	/**
	 * Standard compareTo.
	 * 
	 * @param o
	 *            Object
	 * @return int
	 * @throws ClassCastException
	 */
	@Override
	public int compareTo(Object o) throws ClassCastException {
		final Wheel ot = (Wheel) o;
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
		if (o instanceof Wheel) {
			final Wheel wheel = (Wheel) o;
			if (wheel.getHealth() == this.getHealth())

				return true;
		}
		return false;
	}

	/**
	 * Standard hashCode.
	 * 
	 * @return int
	 */
	@Override public int hashCode() {
		return super.hashCode();
	}
}