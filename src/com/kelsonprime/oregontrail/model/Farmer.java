package com.kelsonprime.oregontrail.model;

public final class Farmer extends Occupation {
	private static final long serialVersionUID = -4579907147578377999L;

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
