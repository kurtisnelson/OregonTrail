package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

public abstract class Occupation implements Serializable {
	private static final long serialVersionUID = -6040773823566650272L;
	
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