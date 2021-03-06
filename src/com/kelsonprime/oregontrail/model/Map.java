package com.kelsonprime.oregontrail.model;

import java.io.Serializable;

/**
 * Represents the game's map
 * 
 * @author Kurt Nelson
 * @version 1.0
 */
public class Map implements Time, Serializable {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -2179958740456509406L;

	/**
	 * First location on the map
	 */
	private final Location start;

	/**
	 * Distance traveled
	 */
	private int traveled;

	/**
	 * Creates the standard game map.
	 * 
	 * @param start
	 *            Location
	 */
	public Map(Location start) {
		traveled = 0;
		this.start = start;
	}

	/**
	 * Gets the distance traveled
	 * 
	 * @return traveled
	 */
	public int getTraveled() {
		return traveled;
	}

	/**
	 * Returns next location in the map
	 * 
	 * @return last location
	 */
	public Location nextLocation() {
		Location loc = start;
		while (loc.next().getPosition() <= traveled) {
			loc = loc.next();
		}
		return loc.next();
	}

	/**
	 * Returns the distance to the next location
	 * 
	 * @return distance
	 */
	public int distanceToNext() {
		return distanceTo(nextLocation());
	}

	/**
	 * Get the distance between two locations
	 * 
	 * @param start
	 *            Location A
	 * @param end
	 *            Location B
	 * 
	 * @return Distance from A to B
	 */
	public static int distanceBetween(Location start, Location end) {
		if (start == null || end == null) {
			return 0;
		}
		return end.getPosition() - start.getPosition();
	}

	/**
	 * Moves up to distance
	 * 
	 * @param distance
	 * @return Location
	 */
	public Location travel(int distance) {
		if (distanceToNext() <= distance) {
			traveled += distanceToNext();
		} else {
			traveled += distance;
		}
		return currentLocation();
	}

	/**
	 * Gets the distance to a particular location
	 * 
	 * @param l
	 *            Location
	 * @return int
	 */
	private int distanceTo(Location l) {
		if (l == null) {
			return 0;
		}
		return l.getPosition() - traveled;
	}

	/**
	 * Traverses the given distance from start
	 * 
	 * @param distance
	 *            int
	 * @return location
	 */
	private Location traverse(int distance) {
		return traverse(start, distance);
	}

	/**
	 * Traverse a distance from a Location
	 * 
	 * @param loc
	 *            Location to start at
	 * @param distance
	 *            Distance to travel
	 * 
	 * @return Location at distance from start, or null if between locations
	 */
	private static Location traverse(Location loc, int distance) {
		if (distance == 0) {
			return loc;
		}
		if (distanceBetween(loc, loc.next()) <= distance) {
			return traverse(loc.next(),
					distance - distanceBetween(loc, loc.next()));
		}
		return null;
	}

	/**
	 * Gets current location
	 * 
	 * @return location
	 */
	public Location currentLocation() {
		return traverse(traveled);
	}

	/**
	 * Method isReady.
	 * 
	 * @return boolean
	 * @see com.kelsonprime.oregontrail.model.Time#isReady()
	 */
	@Override
	public boolean isReady() {
		return true;
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

		// look at pace and # of oxen and move appropriately
		final Wagon wagon = game.getWagon();
		final Pace pace = game.getPace();
		this.travel(pace.getRate() * wagon.countOxen()); // $codepro.audit.disable
															// com.instantiations.assist.eclipse.analysis.unusedReturnValue
	}

	/**
	 * Standard toString
	 * 
	 * @return string
	 */
	@Override
	public String toString() {
		return "A map";
	}

	/**
	 * Get starting location
	 * 
	 * @return start
	 */
	public Location getStart() {
		return start;

	}
	
	public void setFailure(){
		traveled = -1;
	}
}