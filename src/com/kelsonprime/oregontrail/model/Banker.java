package com.kelsonprime.oregontrail.model;

public final class Banker extends Occupation {
	public static String getStaticLabel(){
		return "Banker";
	}
	
	public static int getStaticMoney(){
		return 3000;
	}
	
	public static String getStaticDescription(){
		return "Starts with extra money";
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
