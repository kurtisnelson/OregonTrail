package com.kelsonprime.oregontrail.controller;

import com.kelsonprime.oregontrail.model.Destination;
import com.kelsonprime.oregontrail.model.Location;
import com.kelsonprime.oregontrail.model.Shop;

/**
 * Represents the game's map
 * @author Kurt Nelson
 * @version 1.0
 */
public class Map {

	private Location start;
	private int traveled;

	/**
	 * Contructs map
	 */
	public Map(){
		traveled = 0;
		Location indep = new Shop("Independence");
		Location end = new Destination("The End");
		indep.setNext(end, 50, 0);
		start = indep;
	}
	
	/**
	 * Gets the distance traveled
	 * @return traveled
	 */
	public int getTraveled() {
		return traveled;
	}
	
	/**
	 * Returns next location in the map
	 * @return last location
	 */
	public Location nextLocation(){
		return lastLocation().next();
	}
	
	/**
	 * Returns the distance to the next location
	 * @return distance
	 */
	public int distanceToNext(){
		return distanceTo(nextLocation());
	}
	
	/**
	 * Moves by distance d
	 * @param distance
	 */
	public Location travel(int d){
		if(distanceToNext() <= d){
			traveled += distanceToNext();
		}else{
			traveled += d;
		}
		return currentLocation();
	}
	
	/**
	 * Gets the distance to a particular location
	 */
	private int distanceTo(Location l){
		Location cur = start;
		int processed = 0;
		while(processed < traveled && cur.getRoadLength() + processed < traveled){
			processed += cur.getRoadLength();
			cur = cur.next();
		}
		return cur.getRoadLength() - (traveled - processed);
	}

	/**
	 * Traverses the given distance and gets the new location
	 * @return location
	 */
	private Location traverse(int distance){
		return traverse(start, distance);
	}
	
	private static Location traverse(Location s, int distance){
		int processed = 0;
		Location cur = s;
		while(processed < distance && cur.getRoadLength() + processed < distance){
				processed += cur.getRoadLength();
				cur = cur.next();
		}
		return cur;
	}
	
	void passDay(Game game) {
		// TODO look at pace and # of oxen and move appropriately
	}

	/**
	 * Gets current location
	 * @return location
	 */
	public Location currentLocation() {
		if(traveled == 0)
			return start;
		if(distanceToNext() != 0)
			return null;
		return lastLocation();
	}
	
	/**
	 * Returns the last visited location
	 */
	public Location lastLocation() {
		return traverse(traveled);
	}

}