package com.kelsonprime.oregontrail.model;

/**
 * Represent a river crossing
 * @author Kurt
 * @version 1
 */
public class Crossing extends Location {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 4849948143004178802L;

	/**
	 * Depth of the river
	 */
	private final int depth;

	/**
	 * Width of the river
	 */
	private final int width;

	/**
	 * Cost to take the ferry
	 */
	private int ferryCost;

	/**
	 * Initialize a crossing on the map
	 * @param name
	 * @param position Distance from map start
	 * @param depth How deep is the river
	 * @param width How wide is the river
	 */
	public Crossing(String name, int position, int depth, int width) {
		super(name, position);
		this.depth = depth;
		this.width = width;
		ferryCost = 0;
	}

	/**
	 * Method describe.
	 * @return String
	 */
	public String describe(){
		final StringBuilder ret = new StringBuilder();
		ret.append("This crossing is " + depth + " deep and " + width + " wide.\n");
		if(isFerry()){
			ret.append("There is a ferry that costs " + ferryCost + ".\n");
		}else{
			ret.append("There is no ferry.\n");
		}
		return ret.toString();
	}
	
	/**
	 * Ford this crossing
	
	 * @post Wagon has been updated with anything bad that happened.
	 * @return Description of what happened */
	public String ford() {
		return null;
	}

	/**
	 * Caulk and float at this crossing
	
	 * @post Wagon has been updated with anything bad that happened.
	 * @return Description of what happened */
	public String caulk() {
		return null;
	}

	/**
	 * Add a ferry to this crossing
	 * @param price Price of the ferry
	 */
	public void addFerry(int price){
		this.ferryCost = price;
	}
	
	/**
	 * Check if a ferry is available.
	
	 * @return is there a ferry */
	public boolean isFerry(){
		return ferryCost > 0;
	}

	/**
	 * Take the ferry
	
	 * @post Wagon has been updated with anything bad that happened and cost spent
	 * @return Description of what happened */
	public String ferry() {
		if(ferryCost <= 0)
			return "There is no ferry here.";
		return Integer.toString(ferryCost);
	}

}