package com.kelsonprime.oregontrail.gui;

import javax.swing.JPanel;

import com.kelsonprime.oregontrail.model.Wagon;

public abstract class LocationScreen extends JPanel{
	private static final long serialVersionUID = 2247264002726443781L;
	private Wagon wagon;
	public LocationScreen(Wagon wagon){
		this.wagon = wagon;
	}
	
}