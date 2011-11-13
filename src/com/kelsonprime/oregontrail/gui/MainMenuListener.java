package com.kelsonprime.oregontrail.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kelsonprime.oregontrail.controller.UserInputException;

/**
 * Listen for actions on <code>MainMenu</code>
 */
class MainMenuListener implements ActionListener {
	OregonTrail app;

	/**
	 * Constructor for MainMenuListener.
	 * @param app OregonTrail
	 */
	public MainMenuListener(OregonTrail app) {
		this.app = app;
	}

	/**
	 * Method actionPerformed.
	 * @param event ActionEvent
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("newGame")) {
			app.newGame();
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
