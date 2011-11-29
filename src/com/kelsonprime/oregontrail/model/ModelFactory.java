package com.kelsonprime.oregontrail.model;

import java.util.ArrayList;

import com.kelsonprime.oregontrail.controller.UserInputException;

/**
 */
public class ModelFactory {
	
	/**
	 * Method buildPlayer.
	 * @param name String
	 * @param occupation Occupation
	 * @return Player
	 * @throws UserInputException
	 */
	public static Player buildPlayer(String name, Occupation occupation) throws UserInputException{
		if(name.length() < 1)
			throw new UserInputException("Invalid name");
		if(!validateText(name))
			throw new UserInputException("Invalid characters in name");
		return new Player(name, occupation);
	}
	
	/**
	 * Method buildOccupation.
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
	 * Method buildCompanions.
	 * @param companions String[]
	 * @return ArrayList<Companion>
	 * @throws UserInputException
	 */
	public static ArrayList<Companion> buildCompanions(String... companions) throws UserInputException{
		ArrayList<Companion> companionList = new ArrayList<Companion>(4);
		for(String n : companions){
			if(!validateText(n))
				throw new UserInputException("Invalid characters in companion name");
			companionList.add(new Companion(n));
		}
		return companionList;
	}
	
	/**
	 * Method validateText.
	 * @param text String
	 * @return boolean
	 */
	public static boolean validateText(String text){
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
