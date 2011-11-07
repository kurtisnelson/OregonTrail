package com.kelsonprime.oregontrail.controller;

import com.kelsonprime.oregontrail.model.Destination;
import com.kelsonprime.oregontrail.model.Location;
import com.kelsonprime.oregontrail.model.Shop;
import com.kelsonprime.oregontrail.model.Wagon;

/**
 * Represents the game's map
 * @author Kurt Nelson
 * @version 1.0
 */
public class Map implements Time{

	private Location start;
	private int traveled;
	private Location end;

	/** 
	 * Contructs map
	 */
	public Map(){
		traveled = 0;
		Location indep = new Shop("Independence", 0);
		Location oregon = new Destination("The End", 75);
		Location rest = new Destination("Rest Stop", 100);
		Location fort = new Shop("Fort Hall", 100);
		Location kane = new Destination("Kanesville", 200);
		Location kans= new Shop("Kansas City", 150);
		
		indep.setNext(rest, 50, 0);
		
		rest.setNext(fort,200,0);
		kane.setNext(kane, 250, 0);
		kans.setNext(end, 120, 0);
		
		
		start = indep;
		end = oregon;
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
		Location loc = start;
		while(loc.next().getPosition() < traveled)
			loc = loc.next();
		return loc.next();
	}
	
	/**
	 * Returns the distance to the next location
	 * @return distance
	 */
	public int distanceToNext(){
		return distanceTo(nextLocation());
	}
	
	public static int distanceBetween(Location start, Location end){
		if(start == null || end == null)
			return 0;
		return end.getPosition() - start.getPosition();
	}
	
	/**
	 * Moves up to distance
	 * @param distance
	 */
	public Location travel(int distance){
		if(distanceToNext() <= distance){
			traveled += distanceToNext();
		}else{
			traveled += distance;
		}
		return currentLocation();
	}
	
	/**
	 * Gets the distance to a particular location
	 */
	private int distanceTo(Location l){
		if(l == null)
			return 0;
		return l.getPosition() - traveled;
	}

	/**
	 * Traverses the given distance from start
	 * @return location
	 */
	private Location traverse(int distance){
		return traverse(start, distance);
	}
	
	/**
	 * Traverse a distance from a Location
	 * @param loc Location to start at
	 * @param distance Distance to travel
	 * @return Location at distance from start, or null if between locations
	 */
	private static Location traverse(Location loc, int distance){
		if(distance == 0)
			return loc;
		if(distanceBetween(loc, loc.next()) <= distance)
			return traverse(loc.next(), distance - distanceBetween(loc, loc.next()));
		return null;
	}

	/**
	 * Gets current location
	 * @return location
	 */
	public Location currentLocation() {
		return traverse(traveled);
	}

	@Override
	public boolean isReady() {
		return true;
	}
	
	@Override
	public void nextDay(Game game) {
		//look at pace and # of oxen and move appropriately
		Wagon w = game.getWagon();
		Pace p = game.getPace();
		this.travel(p.getRate() * w.countOxen());
	}
}