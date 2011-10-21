package com.kelsonprime.oregontrail.controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public final class UserProperties extends Properties {
	private static final long serialVersionUID = 6812054977753648712L;
	
	public UserProperties (){
			super();
			try{
				this.loadFromXML(new FileInputStream("user.conf"));
			}catch(Exception e){
				this.initializePrefs();
			}
	}
	public void initializePrefs() {
		this.setProperty("LogLevel", "severe");
		this.savePrefs();
	}
	public void savePrefs() {
		try{
			this.storeToXML(new FileOutputStream("user.conf"), "User Preferences");
		}catch(Exception e){
			// TODO properly log this
		}
	}
}
