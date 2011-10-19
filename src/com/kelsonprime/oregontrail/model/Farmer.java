package com.kelsonprime.oregontrail.model;

public final class Farmer extends Occupation {
	public static String getStaticLabel(){
		return "Farmer";
	}
	
	public static int getStaticMoney(){
		return 1500;
	}
	
	public static String getStaticDescription(){
		return "Takes better care of oxen, and can find food along the way";
	}
	
	@Override
	public int getMoney() {
		return getStaticMoney();
	}

	@Override
	public String getDescription() {
		return getStaticDescription();
	}

	@Override
	public String getLabel() {
		return getStaticLabel();
	}
}
