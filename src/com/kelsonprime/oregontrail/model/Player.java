package com.kelsonprime.oregontrail.model;


public class Player extends Companion {
	private static final long serialVersionUID = -2572176052523635587L;
	private Occupation occupation;

	public Player(String name, Occupation occupation) {
		super(name);
		this.occupation = occupation;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public int startingMoney() {
		return occupation.getMoney();
	}

}