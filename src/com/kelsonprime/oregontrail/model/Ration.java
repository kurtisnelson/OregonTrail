package com.kelsonprime.oregontrail.model;

/**
 * Ration model
 * @author Kurt
 *
 */
public enum Ration {
	BARE(1, "Bare"), MEAGER(1, "Meager"), NORMAL(2, "Normal"), WELLFED(3, "Wellfed");
	private int portion;
	private String name;
	private Ration(int p, String name){
		portion = p;
		this.name = name;
	}
	public String toString(){
		return name;
	}
	public int getPortion(){
		return portion;
	}
}
