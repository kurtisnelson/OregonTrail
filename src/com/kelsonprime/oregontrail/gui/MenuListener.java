package com.kelsonprime.oregontrail.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class MenuListener implements ActionListener, ItemListener {
	OregonTrail app;

	public MenuListener(OregonTrail app) {
		this.app = app;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("newGame")) {
			app.newGameScreen();
		}

	}
}
