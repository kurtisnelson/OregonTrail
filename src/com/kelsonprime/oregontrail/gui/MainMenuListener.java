package com.kelsonprime.oregontrail.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kelsonprime.oregontrail.controller.UserInputException;

public class MainMenuListener implements ActionListener {
	OregonTrail app;

	public MainMenuListener(OregonTrail app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("newGame")) {
			app.newGameScreen();
		} else if (event.getActionCommand().equals("saveGame")){
			try {
				app.saveGame();
			} catch (UserInputException e) {
				e.generateBox(app.getFrame());
			}
		} else if (event.getActionCommand().equals("loadGame")){
			try {
				app.loadGame();
			} catch (UserInputException e) {
				e.generateBox(app.getFrame());
			}
		} else if (event.getActionCommand().equals("exit")) {
			app.exit();
		}
	}
}
