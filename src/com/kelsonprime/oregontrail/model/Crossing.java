package com.kelsonprime.oregontrail.model;

public class Crossing extends Location {

	private int depth;
	private int width;
	private int ferryCost;

	public Crossing(String name, int position, int depth, int width) {
		super(name, position);
		this.depth = depth;
		this.width = width;
		ferryCost = 10;
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
	
	public String ford() {
		return null;
	}

	public String caulk() {
		return null;
	}

	public boolean isFerry(){
		return ferryCost > 0;
	}

	public String ferry() {
		if(ferryCost <= 0)
			return "There is no ferry here.";
		return null;
	}

}