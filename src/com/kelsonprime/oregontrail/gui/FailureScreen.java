package com.kelsonprime.oregontrail.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class FailureScreen extends JPanel {
	
	private static final long serialVersionUID = -2295115978365444694L;

	public FailureScreen(){
		super();
		
		JLabel lblYouHaveLost = new JLabel("You have lost.\nIf you wish to try again either\n LOAD a previous save\nOR\nSTART a new game!");
		add(lblYouHaveLost);
		
	}
}
