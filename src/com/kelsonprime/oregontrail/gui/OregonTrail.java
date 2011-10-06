package com.kelsonprime.oregontrail.gui;

import com.kelsonprime.oregontrail.logic.Game;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.awt.Dimension;

/**
 * This class is going to be the main game. It is in charge of owning the parent
 * JFrame, and adding the initial menu to it
 * 
 */
public class OregonTrail {
	Game game;
	JMenuBar mainMenu;
	
	private static JFrame frame;

	public void newGameScreen(){
		JPanel newGameFrame = new NewGameScreen(this);
		frame.add(newGameFrame);
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
	
	public void open(){
		frame.setVisible(true);
	}
	
	public void exit(){
		frame.setVisible(false);
		System.exit(0);
	}

	public void setGame(Game game) {
		this.game = game;
	}
}