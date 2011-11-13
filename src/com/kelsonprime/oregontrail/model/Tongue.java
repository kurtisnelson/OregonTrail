package com.kelsonprime.oregontrail.model;

/**
 */
public class Tongue extends Part {
	private static final long serialVersionUID = 8766537377409751997L;

	/**
	 * Constructor for Tongue.
	 * @param health int
	 */
	public Tongue(int health) {
		super(health);
	}

	public Tongue() {
		this(125);
	}
	
	/**
	 * Method getWeight.
	 * @return int
	 */
	public static int getWeight(){
		return 5;
	}
	
	/**
	 * Method toString.
	 * @return String
	 */
	public String toString() {
		return "Tongue at "+health;
	}

	/**
	 * Method compareTo.
	 * @param o Object
	 * @return int
	 */
	@Override
	public int compareTo(Object o) {
		if(o instanceof Tongue){
			Tongue ot = (Tongue) o;
			return ot.health - this.health;
		}
		return this.toString().compareTo(o.toString());
	}

	/**
	 * Method equals.
	 * @param o Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Tongue){
			Tongue a = (Tongue) o;
			if(a.getHealth() == this.getHealth())
				return true;
		}
		return false;
	}
	
	/**
	 * Method hashCode.
	 * @return int
	 */
	public int hashCode(){
		return super.hashCode();
	}
}