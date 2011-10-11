package com.kelsonprime.oregontrail.gui;

import javax.swing.JPanel;

import com.kelsonprime.oregontrail.controller.Game;

public abstract class LocationScreen extends JPanel{
	private static final long serialVersionUID = 2247264002726443781L;
	private Game game;
	public LocationScreen(Game game){
		this.game = game;
	}
	
}