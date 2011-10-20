package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.Threader;
import com.kelsonprime.oregontrail.controller.UserProperties;
import com.kelsonprime.oregontrail.model.Location;
import com.kelsonprime.oregontrail.model.Shop;

/**
 * This class is going to be the main game. It is in charge of owning the parent
 * JFrame, and adding the initial menu to it
 * 
 */
public class OregonTrail {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public final static UserProperties userProperties = new UserProperties();
	Game game;
	JMenuBar mainMenu;
	JPanel mainPanel;
	private JFrame frame;

	public void newGameScreen() {
		setPanel(new NewGameScreen(this));
	}

	private void setPanel(JPanel p) {
		frame.add(p);
		if (mainPanel != null)
			frame.remove(mainPanel);
		mainPanel = p;
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Load in logging prefs
		String level = userProperties.getProperty("LogLevel", "severe");
		if (level.equalsIgnoreCase("all"))
			LOGGER.setLevel(Level.ALL);
		else if (level.equalsIgnoreCase("severe"))
			LOGGER.setLevel(Level.SEVERE);
		try {
			Handler h = new FileHandler("OregonTrail.log");
			LOGGER.addHandler(h);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Failed to add log handler", e);
		}
		LOGGER.setUseParentHandlers(false);
		LOGGER.log(Level.INFO, "App started");
		
		 //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
		Threader.executeNow(new Runnable() {
            public void run() {
            	OregonTrail app = new OregonTrail();
            	app.open();
            }
        });
	}

	public OregonTrail() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			LOGGER.log(Level.WARNING, "Unsupported look and feel", e);
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Look and feel issue", e);
		}
		this.mainMenu = new MainMenu(this);
		frame = new JFrame("Oregon Trail");
		frame.setIconImage(new ImageIcon("images/OregonTrailIcon.png").getImage());
		frame.setResizable(false);
		setPanel(new SplashScreen());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 350));

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// Determine the new location of the window
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (dim.width / 2) - w / 2;
		int y = (dim.height / 2) - h / 2;
		// Move the window
		frame.setLocation(x, y);
	}

	public JFrame getFrame() {
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
		userProperties.savePrefs();
		System.exit(0);
	}

	public void loadGame(Game game) {
		this.game = game;
		game.setOwner(this);
		updateScreen();
	}

	public void updateScreen() {
		Location cur = game.currentLocation();
		if (cur == null) {
			// TODO show screen for moving along
		} else if (cur instanceof Shop) {
			setPanel(new ShopScreen(game, (Shop) cur));
		}
	}
}
