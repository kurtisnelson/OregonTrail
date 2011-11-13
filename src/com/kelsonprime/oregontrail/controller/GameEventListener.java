package com.kelsonprime.oregontrail.controller;

import java.util.LinkedHashSet;
import java.util.Set;

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
	Set<Updatable> updatables;
	
	public GameEventListener(){
		updatables = new LinkedHashSet<Updatable>();
	}

	public void traveled(){
		parent.updateScreen();
	}
	
	/**
	 * Register an object to be notified of updates
	 * @param obj <code>Updatable</code>
	 */
	public void registerUpdatable(Updatable obj){
		updatables.add(obj);
	}
	
	public void dispatchUpdate(){
		for(Updatable u : updatables)
			u.update();
	}
	
	/**
	 * Select the app that owns this
	 * @param owner OregonTrail
	 */
	public void setOwner(OregonTrail owner){
		this.parent = owner;
	}
}