package com.kelsonprime.oregontrail.model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kelsonprime.oregontrail.controller.UserInputException;

public class ModelFactory {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static Player buildPlayer(String name, Occupation occupation) throws UserInputException{
		if(name.length() < 1)
			throw new UserInputException("Invalid name");
		if(!validateText(name))
			throw new UserInputException("Invalid characters in name");
		return new Player(name, occupation);
	}
	
	public static Occupation buildOccupation(String occ) throws UserInputException{
		Occupation newOccupation = null;
		try {
			Class<?> c = Class.forName(occ);
			if(!Occupation.class.isAssignableFrom(c)){
				c = Class.forName("com.kelsonprime.oregontrail.model."+occ);
				if(!c.isInstance(Occupation.class)){
					throw new UserInputException("Not an occupation.");
				}
			}
			Constructor<?> co = c.getConstructor();
			return (Occupation) co.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			if(occ.length() > 0)
				throw new UserInputException("Invalid occupation specified.");
			throw new UserInputException("No occupation specified.");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Occupation reflection failed", e);
		}
		return newOccupation;
	}
	
	public static ArrayList<Companion> buildCompanions(String... companions) throws UserInputException{
		ArrayList<Companion> companionList = new ArrayList<Companion>(4);
		for(String n : companions){
			if(!validateText(n))
				throw new UserInputException("Invalid characters in companion name");
			companionList.add(new Companion(n));
		}
		return companionList;
	}
	
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
