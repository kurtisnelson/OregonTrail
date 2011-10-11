package com.kelsonprime.oregontrail.controller;

import java.util.ArrayList;

import com.kelsonprime.oregontrail.model.Banker;
import com.kelsonprime.oregontrail.model.Carpenter;
import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Farmer;
import com.kelsonprime.oregontrail.model.Occupation;
import com.kelsonprime.oregontrail.model.Player;

public class ModelFactory {
	
	public static Player buildPlayer(String name, Occupation occupation) throws UserInputException{
		if(name.length() < 1)
			throw new UserInputException("Invalid name");
		if(!validateText(name))
			throw new UserInputException("Invalid characters in name");
		return new Player(name, occupation);
	}
	
	public static Occupation buildOccupation(String occ) throws UserInputException{
		Occupation newOccupation;
		if (occ.equals("banker")) {
			newOccupation = new Banker();
		} else if (occ.equals("carpenter")) {
			newOccupation = new Carpenter();
		} else if (occ.equals("farmer")){
			newOccupation = new Farmer();
		} else {
			throw new UserInputException("No occupation selected.");
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
