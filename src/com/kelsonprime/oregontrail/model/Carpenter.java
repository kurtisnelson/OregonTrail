package com.kelsonprime.oregontrail.model;

public final class Carpenter extends Occupation {
	private static final long serialVersionUID = -8843042214187651692L;

	public static String getStaticLabel(){
		return "Carpenter";
	}
	
	public static int getStaticMoney(){
		return 2000;
	}
	
	public static String getStaticDescription(){
		return "Can fix wagon parts when they break.";
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
