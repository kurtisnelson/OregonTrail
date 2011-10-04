package com.kelsonprime.oregontrail.logic;

abstract class Part implements PassDay{
	protected int health;
	protected final double WEARRATIO = .01; 

	/**
	 * 
	 * @param game
	 */
	public Part(int health){
		this.health = health;
	}
	public void passDay(Game game){
		health = (int) (health - (health *.01));
		// TODO account for pace with game.getPace()
	}
}