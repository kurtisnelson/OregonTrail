package com.kelsonprime.oregontrail.model;

import java.util.ArrayList;

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
		if(name.length() < 1)
			throw new UserInputException("Invalid name");
		if(!isText(name))
			throw new UserInputException("Invalid characters in name");
		return new Player(name, occupation);
	}
	
	/**
	 * Make an occupation from label
	 * @param name Occupation label
	 * @return Occupation
	 * @throws UserInputException
	 */
	public static Occupation buildOccupation(String name) throws UserInputException{
		for(Occupation occ : Occupation.getOccupations()){
			if(occ.toString().equals(name))
				return occ;
		}
		throw new UserInputException("Invalid Occupation");
	}
	
	/**
	 * Make companions from names
	 * @param companions String[] Names to use
	 * @return ArrayList<Companion>
	 * @throws UserInputException
	 */
	public static ArrayList<Companion> buildCompanions(String... companions) throws UserInputException{
		ArrayList<Companion> companionList = new ArrayList<Companion>(4);
		for(String n : companions){
			if(!isText(n))
				throw new UserInputException("Invalid characters in companion name");
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
		for(char c : text.toCharArray()){
			if(c >= 'A' && c <= 'Z')
				continue;
			if(c >= 'a' && c <= 'z')
				continue;
			if(c >= '0' && c <= '9')
				continue;
			return false;
		}
		return true;
	}
}
