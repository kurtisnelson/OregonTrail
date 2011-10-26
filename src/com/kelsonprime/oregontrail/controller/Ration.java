package com.kelsonprime.oregontrail.controller;

/**
 * Enumarates the ration
 * @author Aman
 *
 */
public enum Ration {
	BARE(1, "Bare"), MEAGER(1, "Meager"), NORMAL(2, "Normal"), WELLFED(3, "Wellfed");
	int portion;
	String name;
	private Ration(int p, String name){
		portion = p;
		this.name = name;
	}
}
