package com.kelsonprime.oregontrail.logic;
import com.kelsonprime.oregontrail.gui.Listener;

public class Game {

	Listener reciever;
	Wagon wagon;
	private int date;
	private Pace pace;
	private Ration ration;

	public Game(Listener reciever){
		this.reciever = reciever;
		this.date = 0;
		this.pace = Pace.NORMAL;
		this.ration = Ration.NORMAL;
		this.wagon = new Wagon();		
	}
	
	/**
	 * 
	 * @param item
	 */
	public void acceptTrade(Object item) {
		// TODO method stub
	}

	public void hunt() {
		// TODO method stub
	}

	public void rest() {
		// TODO method stub
	}

	public int getPace() {
		// TODO method stub
		return 0;
	}

	/**
	 * 
	 * @param pace
	 */
	public void setPace(Pace pace) {
		this.pace = pace;
	}

	public int getRation() {
		// TODO method stub
		return 0;
	}

	/**
	 * 
	 * @param ration
	 */
	public void setRation(Ration ration) {
		this.ration = ration;
	}

	public boolean beginDay() {
		// TODO method stub
		return false;
	}

	/**
	 * Call pass day on EVERYTHING
	 */
	private void passDay() {
		// TODO method stub
	}
	public Part offerTrade(Part need, int quantity) {
		// TODO method stub
		return null;
	}

}
