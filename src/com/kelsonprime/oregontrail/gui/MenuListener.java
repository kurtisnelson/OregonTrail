package com.kelsonprime.oregontrail.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;



public class MenuListener implements ActionListener, ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("newGame")){
			JFrame newGameFrame = new NewGameScreen("New Game");
			newGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			newGameFrame.pack();
			newGameFrame.setVisible(true);
		}
		
	}

}
