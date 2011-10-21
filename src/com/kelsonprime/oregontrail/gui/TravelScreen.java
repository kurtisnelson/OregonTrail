package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class TravelScreen extends JPanel {
	private static final long serialVersionUID = -2616586129314449978L;
	
	OregonTrail app;
	
	public TravelScreen(OregonTrail app){
		super();
		this.app = app;
		setSize(new Dimension(600, 300));
		
		JLabel lblTravel = new JLabel("TRAVEL!");
		add(lblTravel);
	}
}
