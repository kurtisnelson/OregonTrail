package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.model.*;

/**
 * This class is going to be the main game. It is in charge of owning the parent
 * JFrame, and adding the initial menu to it
 * 
 */
public class OregonTrail {
	Game game;
	JMenuBar mainMenu;
	JPanel currentPanel;

	private static JFrame frame;

	public void newGameScreen() {
		currentPanel = new NewGameScreen(this);
		frame.add(currentPanel);
		frame.pack();
		frame.setSize(new Dimension(600, 350));
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Thread this app creation, throw up a splash screen until done.
		OregonTrail app = new OregonTrail();
		app.open();
	}

	public OregonTrail() {
		this.mainMenu = new MainMenu(this);
		frame = new JFrame("Oregon Trail");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(mainMenu);
		frame.pack();
		frame.setSize(new Dimension(600, 300));
	}

	public void open() {
		frame.setVisible(true);
	}

	public void exit() {
		frame.setVisible(false);
		System.exit(0);
	}

	public void setGame(Game game) {
		this.game = game;
		frame.remove(currentPanel);
		currentPanel = new ShopScreen(new Shop("Independence Town"));
		frame.add(currentPanel);
		frame.pack();
		frame.setSize(new Dimension(600,350));
		frame.setVisible(true);
	}
}