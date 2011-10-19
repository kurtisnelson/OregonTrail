package com.kelsonprime.oregontrail.model;

public abstract class Occupation {
	
	public static Class<?>[] getOccupations(){
		Class<?>[] occs = new Class[3];
		occs[0] = Banker.class;
		occs[1] = Carpenter.class;
		occs[2] = Farmer.class;
		return occs;
	}
	
	public Occupation(){
		
	}
	
	public abstract int getMoney();
	public abstract String getDescription();
	public abstract String getLabel();
}