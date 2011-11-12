package com.kelsonprime.oregontrail.model;

/**
 * Represents the game's map
 * @author Kurt Nelson
 * @version 1.0
 */
public class Map implements Time{

	private Location start;
	private int traveled;

	/** 
	 * Creates the standard game map.
	 */
	public Map(){
		traveled = 0;
		Location indep = new Shop("Independence", 0);
		start = indep;
		Location river1 = new Crossing("River", 10, 5, 10);
		indep.setNext(river1, 10, 0);
		Location rock = new Landmark("The Big Rock", 20);
		river1.setNext(rock, 10, 0);
		Location town = new Town("A town", 30);
		rock.setNext(town, 0, 10);
		Location shop = new Shop("A shop", 40);
		town.setNext(shop, 10, 0);
		Location end = new Destination("The End", 50);
		shop.setNext(end, 10, 10);
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