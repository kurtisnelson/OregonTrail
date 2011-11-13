package com.kelsonprime.oregontrail.model;

/**
 */
public class Wheel extends Part {
	private static final long serialVersionUID = 6617454331985073863L;

	/**
	 * Constructor for Wheel.
	 * @param health int
	 */
	public Wheel(int health) {
		super(health);
	}

	public Wheel() {
		this(80);
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
		return "Wheel";
	}

	/**
	 * Method compareTo.
	 * @param o Object
	 * @return int
	 */
	@Override
	public int compareTo(Object o) {
		if(o instanceof Wheel){
			Wheel ot = (Wheel) o;
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
		if(o instanceof Wheel){
			Wheel a = (Wheel) o;
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