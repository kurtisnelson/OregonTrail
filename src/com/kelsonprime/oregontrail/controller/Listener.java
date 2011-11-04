package com.kelsonprime.oregontrail.controller;

import java.util.LinkedList;
import java.util.List;

import com.kelsonprime.oregontrail.gui.OregonTrail;

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
	List<Updatable> updatables;
	
	public Listener(){
		updatables = new LinkedList<Updatable>();
	}

	public void traveled(){
		parent.updateScreen();
	}
	
	public void registerUpdatable(Updatable f){
		if(!updatables.contains(f))
			updatables.add(f);
	}
	
	public void update(){
		for(Updatable u : updatables)
			u.update();
	}
	
	public void setOwner(OregonTrail owner){
		this.parent = owner;
	}
}