package com.kelsonprime.oregontrail.model;

/**
 * Represents an Axle.
 * @author Kurt
 *
 * @version $Revision: 1.0 $
 */
public class Axle extends Part {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 3548664315971140887L;
	
	/**
	 * Default health of this part (value is 100)
	 */
	private static final int DEFAULT_HEALTH = 100;

	/**
	 * Default weight of this part (value is 5)
	 */
	private static final int DEFAULT_WEIGHT = 5;

	/**
	 * Constructor without arguments
	 */
	public Axle(){
		this(DEFAULT_HEALTH);
	}
	
	/**
	 * Constructor with health given
	 * @param health int
	 */
	public Axle(int health) {
		super(health);
	}
	
	/**
	 * Gets the name of the part in string form
	 * @return String
	 */
	public String toString() {
		return "Axle";
	}
	
	/**
	 * Get the weight of the part
	 * @return int Part weight
	 */
	public static int getWeight(){
		return DEFAULT_WEIGHT;
	}
	
	/**
	 * Standard compareTo.
	 * @param o Object
	 * @return int
	 * @throws ClassCastException
	 */
	@Override
	public int compareTo(Object o) throws ClassCastException {
		Axle ot = (Axle) o;
		return ot.health - this.health;
	}

	/**
	 * Standard equals.
	 * @param o Object
	 * @return boolean
	 * @see com.kelsonprime.oregontrail.model.Time#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o instanceof Axle){
			Axle axle = (Axle) o;
			if(axle.getHealth() == this.getHealth())
				return true;
		}
		return false;
	}
	
	/**
	 * Standard hashCode.
	 * @return int
	 */
	@Override
	public int hashCode(){
		return super.hashCode();
	}
}