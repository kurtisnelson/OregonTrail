package com.kelsonprime.oregontrail.controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manage the User's preferences file
 * @author Kurt
 */
public final class UserProperties extends Properties {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final long serialVersionUID = 6812054977753648712L;
	
	public UserProperties (){
			super();
			try{
				this.loadFromXML(new FileInputStream("user.conf"));
			}catch(Exception e){
				LOGGER.log(Level.FINE, "Creating new user.conf preferences file");
				this.initializePrefs();
			}
	}
	
	/**
	 * Create a pref file with default preferences
	 */
	public void initializePrefs() {
		this.setProperty("LogLevel", "severe");
		this.savePrefs();
	}
	
	/**
	 * Save preferences to file
	 */
	public void savePrefs() {
		try{
			this.storeToXML(new FileOutputStream("user.conf"), "User Preferences");
		}catch(Exception e){
			LOGGER.log(Level.FINE, "Did not save updated preferences");
		}
	}
}
