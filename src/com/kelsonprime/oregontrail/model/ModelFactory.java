// $codepro.audit.disable numericLiterals
package com.kelsonprime.oregontrail.model;

import java.util.ArrayList;
import java.util.List;

import com.kelsonprime.oregontrail.controller.UserInputException;

/**
 * Creates various models
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class ModelFactory {
	
	/**
	 * Make a player
	 * @param name String
	 * @param occupation Occupation
	 * @return Player
	 * @throws UserInputException
	 */
	public static Player buildPlayer(String name, Occupation occupation) throws UserInputException{
		if(name.length() < 1){
			throw new UserInputException("Invalid name");
		}
		if(!isText(name)){
			throw new UserInputException("Invalid characters in name");
		}
		return new Player(name, occupation);
	}
	
	/**
	 * Make standard map
	 * @return Map
	 */
	public static Map buildMap(){
		final Map map = new Map(new Shop("Independence", 0));
		final Location river1 = new Crossing("River", 10, 5, 10);
		map.getStart().setNext(river1, 10, 0);
		final Location rock = new Landmark("The Big Rock", 20);
		river1.setNext(rock, 10, 0);
		final Location town = new Town("A town", 30);
		rock.setNext(town, 0, 10);
		final Location shop = new Shop("A shop", 40);
		town.setNext(shop, 10, 0);
		final Location end = new Destination("The End", 50);
		shop.setNext(end, 10, 10);
		return map;
	}
	
	/**
	 * Make an occupation from label
	 * @param name Occupation label
	 * @return Occupation
	 * @throws UserInputException
	 */
	public static Occupation buildOccupation(String name) throws UserInputException{
		for(Occupation occ : Occupation.getOccupations()){
			if(occ.toString().equals(name)){
				return occ;
			}
		}
		throw new UserInputException("Invalid Occupation");
	}
	
	/**
	 * Make companions from names
	 * @param companions String[] Names to use
	 * @return ArrayList<Companion>
	 * @throws UserInputException
	 */
	public static List<Companion> buildCompanions(String... companions) throws UserInputException{
		final List<Companion> companionList = new ArrayList<Companion>(4);
		for(String n : companions){
			if(!isText(n)){
				throw new UserInputException("Invalid characters in companion name");
			}
			companionList.add(new Companion(n));
		}
		return companionList;
	}
	
	/**
	 * Check if is text
	 * @param text String
	 * @return boolean
	 */
	public static boolean isText(String text){
		return text.matches("[A-Za-z0-9]*");
	}
	
	/**
	 * Standard toString
	 * @return string
	 */
	public String toString(){
		return "";
	}
}
