package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.model.Location;
import com.kelsonprime.oregontrail.model.Shop;

/**
 * This class is going to be the main game. It is in charge of owning the parent
 * JFrame, and adding the initial menu to it
 * 
 */
public class OregonTrail {
	Game game;
	JMenuBar mainMenu;
	JPanel mainPanel;
	private JFrame frame;

	public void newGameScreen() {
		setPanel(new NewGameScreen(this));
	}

	private void setPanel(JPanel p){
		new Thread(new PanelSetter(p)).run();
	}
	
	private class PanelSetter implements Runnable {
		private JPanel p;
		public PanelSetter(JPanel p){
			this.p = p;
		}
		@Override
		public void run() {
			frame.add(p);
			if(mainPanel != null)
				frame.remove(mainPanel);
			mainPanel = p;
			frame.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		// TODO Thread this app creation, throw up a splash screen until done.
		OregonTrail app = new OregonTrail();
		app.open();
	}

	public OregonTrail() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.mainMenu = new MainMenu(this);
		frame = new JFrame("Oregon Trail");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame(){
		return frame;
	}
	
	public void open() {
		frame.setJMenuBar(mainMenu);
		frame.setSize(new Dimension(600, 350));
		frame.setVisible(true);
	}

	public void exit() {
		frame.setVisible(false);
		// TODO do any cleanup
		System.exit(0);
	}

	public void loadGame(Game game) {
		this.game = game;
		game.setOwner(this);
		updateScreen();
	}
	
	public void updateScreen(){
		Location cur = game.currentLocation();
		if(cur == null){
			// TODO show screen for moving along
		}else if(cur instanceof Shop){
			setPanel(new ShopScreen(game, (Shop)cur));
		}
	}
}