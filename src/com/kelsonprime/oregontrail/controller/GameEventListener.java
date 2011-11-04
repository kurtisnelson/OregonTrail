package com.kelsonprime.oregontrail.controller;

import java.util.LinkedList;
import java.util.List;

import com.kelsonprime.oregontrail.gui.OregonTrail;

/**
 * This object allows other classes to register for event notifications from it. Events are dispatched from here to all registered objects.
 * 
 * @author Kurt Nelson
 * @version 1
 * 
 */
public class GameEventListener {
	OregonTrail parent;
	List<Updatable> updatables;
	
	public GameEventListener(){
		updatables = new LinkedList<Updatable>();
	}

	public void traveled(){
		parent.updateScreen();
	}
	
	public void registerUpdatable(Updatable f){
		if(!updatables.contains(f))
			updatables.add(f);
	}
	
	public void dispatchUpdate(){
		for(Updatable u : updatables)
			u.update();
	}
	
	public void setOwner(OregonTrail owner){
		this.parent = owner;
	}
}