package com.kelsonprime.oregontrail.controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class Properties extends java.util.Properties {

	public Properties (){
			super();
			try{
				this.loadFromXML(new FileInputStream("user.conf"));
			}catch(Exception e){
				this.savePrefs();
			}
	}
	
	public void savePrefs() {
		try{
			this.storeToXML(new FileOutputStream("user.conf"), "User");
		}catch(Exception e){
			// TODO properly log this
		}
	}
}
