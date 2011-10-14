package com.kelsonprime.oregontrail.controller;

import com.kelsonprime.oregontrail.model.Location;
import com.kelsonprime.oregontrail.model.Shop;

public class Map {

	private Location start;
	private int traveled;

	public Map(){
		traveled = 0;
		start = new Shop("Independence");
	}
	
	public int getTraveled() {
		return traveled;
	}
	
	public Location nextLocation(){
		return lastLocation().next();
	}
	
	public int distanceToNext(){
		return distanceTo(nextLocation());
	}
	
	public Location travel(int d){
		if(distanceToNext() <= d){
			traveled += distanceToNext();
		}else{
			traveled += d;
		}
		return currentLocation();
	}
	
	private int distanceTo(Location l){
		Location cur = start;
		int processed = 0;
		while(processed < traveled && cur.getRoadLength() + processed < traveled){
			processed += cur.getRoadLength();
			cur = cur.next();
		}
		return cur.getRoadLength() - (traveled - processed);
	}

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

	public Location currentLocation() {
		if(distanceToNext() != 0)
			return null;
		return lastLocation();
	}
	
	public Location lastLocation() {
		return traverse(traveled);
	}

}