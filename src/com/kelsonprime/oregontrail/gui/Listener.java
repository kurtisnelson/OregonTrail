package com.kelsonprime.oregontrail.gui;

/**
 * 
 * this class is the go between for the logic and the gui. When something
 * changes in the logic, it tells the Listener (by calling some method in the
 * listener) The Listener then updates the gui (in whatever manner we implement)
 * 
 * @author Matt
 * 
 */
public class Listener {
	OregonTrail parent;
	public Listener(){
		
	}

	public void traveled(){
		parent.updateScreen();
	}
	
	public void setOwner(OregonTrail owner){
		this.parent = owner;
	}
}