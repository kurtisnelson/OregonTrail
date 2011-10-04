package com.kelsonprime.oregontrail.logic;

public class Player extends Companion {

	private Occupation occupation;

	Occupation getOccupation() {
		return occupation;
	}
	
	int startingMoney(){
		return occupation.startingMoney();
	}

}