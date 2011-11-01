package com.kelsonprime.oregontrail.model;

public class Crossing extends Location {

	private int depth;
	private int width;
	private int ferryCost;

	/**
	 * Initialize a crossing on the map
	 * @param name
	 * @param position Distance from map start
	 * @param depth
	 * @param width
	 */
	public Crossing(String name, int position, int depth, int width) {
		super(name, position);
		this.depth = depth;
		this.width = width;
		ferryCost = 0;
	}

	public String describe(){
		StringBuilder ret = new StringBuilder();
		ret.append("This crossing is "+depth+" deep and "+width+" wide.\n");
		if(isFerry())
			ret.append("There is a ferry that costs "+ferryCost+".\n");
		else
			ret.append("There is no ferry.\n");
		return ret.toString();
	}
	
	/**
	 * Ford this crossing
	 * @return Description of what happened
	 * @post Wagon has been updated with anything bad that happened.
	 */
	public String ford() {
		return null;
	}

	/**
	 * Caulk and float at this crossing
	 * @return Description of what happened
	 * @post Wagon has been updated with anything bad that happened.
	 */
	public String caulk() {
		return null;
	}

	/**
	 * Check if a ferry is available.
	 * @return is there a ferry
	 */
	public boolean isFerry(){
		return ferryCost > 0;
	}

	/**
	 * Take the ferry
	 * @return Description of what happened
	 * @post Wagon has been updated with anything bad that happened and cost spent
	 */
	public String ferry() {
		if(ferryCost <= 0)
			return "There is no ferry here.";
		return null;
	}

}