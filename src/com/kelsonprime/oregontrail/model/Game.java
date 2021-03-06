// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
package com.kelsonprime.oregontrail.model;

import java.io.Serializable;
import java.util.List;

import com.kelsonprime.oregontrail.controller.GameEventListener;
import com.kelsonprime.oregontrail.gui.OregonTrail;

/**
 * This class holds information about a game.
 * 
 * @author Aman Jain
 * 
 * @version $Revision: 1.0 $
 */
public class Game implements Time, Serializable {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -1328327188493685888L;

	/**
	 * GUI hook for event notifications
	 */
	private transient GameEventListener reciever;

	/**
	 * The wagon
	 */
	private final Wagon wagon;

	/**
	 * The map
	 */
	private final Map map;

	/**
	 * How many days have passed
	 */
	private int days;

	/**
	 * Current pace
	 */
	private Pace pace;

	/**
	 * Current ration
	 */
	private Ration ration;

	/**
	 * Constructs Game object and initializes all variables like map, wagon etc
	 * 
	 * @param wagon
	 *            Wagon
	 */
	public Game(Wagon wagon) {
		this.reciever = new GameEventListener();
		this.days = 0;
		this.pace = Pace.STEADY;
		this.ration = Ration.NORMAL;
		this.wagon = wagon;
		this.map = ModelFactory.buildMap();
	}

	/**
	 * Method getListener.
	 * 
	 * @return GameEventListener
	 */
	public GameEventListener getListener() {
		return this.reciever;
	}

	/**
	 * Gets current location on map
	 * 
	 * 
	 * @return location
	 */
	public Location currentLocation() {
		return map.currentLocation();
	}

	/**
	 * Number of days since game start
	 * 
	 * 
	 * @return days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * Current pace
	 * 
	 * 
	 * @return pace
	 */
	public Pace getPace() {
		return pace;
	}

	/**
	 * Sets the pace of the game
	 * 
	 * @param pace
	 */
	public void setPace(Pace pace) {
		this.pace = pace;
	}

	/**
	 * Accepts a trade item
	 * 
	 * @param item
	 */
	public void acceptTrade(Object item) {
		// TODO method stub
	}

	/**
	 * Does bookkeeping for hunting
	 */
	public void hunt() {
		// TODO method stub
	}

	/**
	 * Gets the ration left
	 * 
	 * 
	 * @return ration
	 */
	public Ration getRation() {
		return ration;
	}

	/**
	 * Sets the ration
	 * 
	 * @param ration
	 */
	public void setRation(Ration ration) {
		this.ration = ration;
	}

	/**
	 * Method isReady.
	 * 
	 * @return boolean
	 * @see com.kelsonprime.oregontrail.model.Time#isReady()
	 */
	@Override public boolean isReady() {
		for (Companion person: wagon.getParty()){
			if (person.isReady())
				return true;
		}
		return false;
	}

	/**
	 * Offers a part to trade
	 * 
	 * @param need
	 *            What <code>Part</code> the player needs
	 * @param quantity
	 *            How many of need
	 * 
	 * @return part A list of parts they would give to get need
	 */
	public List<Part> offerTrade(Part need, int quantity) {
		// TODO method stub
		return null;
	}

	/**
	 * Gets the wagon
	 * 
	 * 
	 * @return wagon
	 */
	public Wagon getWagon() {
		return wagon;
	}

	/**
	 * Move from location
	 */
	public void leaveLocation() {
		map.travel(1); // $codepro.audit.disable
						// com.instantiations.assist.eclipse.analysis.unusedReturnValue
	}

	/**
	 * Rest for a day
	 */
	public void rest() {
		final Pace oldPace = this.getPace();
		this.setPace(Pace.STOPPED);
		nextDay();
		this.setPace(oldPace);
	}

	/**
	 * Gets the current map
	 * 
	 * 
	 * @return map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * Sets the owner of the game
	 * 
	 * @param owner
	 *            OregonTrail
	 */
	public void setOwner(OregonTrail owner) {
		if (reciever == null) {
			reciever = new GameEventListener();
		}
		reciever.setOwner(owner);
	}

	/**
	 * Pass a day
	 */
	public void nextDay() {
		// TODO hit Events.
		if (isReady()){
			wagon.nextDay(this);
			map.nextDay(this);
			days++;
		} else {
			
		}
	}

	/**
	 * Method nextDay.
	 * 
	 * @param game
	 *            Game
	 * @see com.kelsonprime.oregontrail.model.Time#nextDay(Game)
	 */
	@Override
	public void nextDay(Game game) {
		nextDay();
	}

}
