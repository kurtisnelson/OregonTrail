package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

import com.kelsonprime.oregontrail.controller.GameEventListener;
import com.kelsonprime.oregontrail.controller.Threader;
import com.kelsonprime.oregontrail.controller.UserInputException;
import com.kelsonprime.oregontrail.controller.UserProperties;
import com.kelsonprime.oregontrail.model.Crossing;
import com.kelsonprime.oregontrail.model.Game;
import com.kelsonprime.oregontrail.model.Landmark;
import com.kelsonprime.oregontrail.model.Location;
import com.kelsonprime.oregontrail.model.Map;
import com.kelsonprime.oregontrail.model.Shop;
import com.kelsonprime.oregontrail.model.Town;
import com.kelsonprime.oregontrail.model.Wagon;

/**
 * Main class for the Application. Tracks all other objects and performs setup and tear down.
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class OregonTrail {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public final static UserProperties userProperties = new UserProperties();
	public final static int WIDTH = 600;
	public final static int HEIGHT = 350;
	private Game game;
	JMenuBar mainMenu;
	JPanel mainPanel;
	private JFrame frame;

	/**
	 * Method main.
	 * @param args String[]
	 */
	public static void main(String[] args) {
		// Load in logging prefs
		String level = userProperties.getProperty("LogLevel", "severe");
		if (level.equalsIgnoreCase("all"))
			LOGGER.setLevel(Level.ALL);
		else if (level.equalsIgnoreCase("severe"))
			LOGGER.setLevel(Level.SEVERE);
		try {
			Handler handler = new FileHandler("OregonTrail.log");
			LOGGER.addHandler(handler);
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

	/**
	 * Create in memory a new instance of the application
	 */
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
		frame.setSize(new Dimension(WIDTH, HEIGHT));

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// Determine the new location of the window
		int x = (dim.width / 2) - WIDTH / 2;
		int y = (dim.height / 2) - HEIGHT / 2;
		// Move the window
		frame.setLocation(x, y);
	}

	/**
	 * Get app's main JFrame
	
	 * @return main JFrame */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Make the app visible
	 */
	public void open() {
		frame.setJMenuBar(mainMenu);
		frame.setSize(new Dimension(WIDTH, HEIGHT));
		frame.setVisible(true);
	}

	/**
	 * Clean up and exit the application completely.
	 */
	public void exit() {
		frame.setVisible(false);
		userProperties.savePrefs();
		System.exit(0);
	}

	/**
	 * Save game with serialization
	
	 * @throws UserInputException  */
	public void saveGame() throws UserInputException {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("savedGame");
			out = new ObjectOutputStream(fos);
			out.writeObject(game);
			out.close();
		} catch (IOException ex) {
			LOGGER.log(Level.WARNING, "Save failed.", ex);
			throw new UserInputException("Save failed");
		}
	}
	
	/**
	 * Load game using serialization
	
	 * @throws UserInputException  */
	public void loadGame() throws UserInputException {
		Game loadedGame = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream("savedGame");
			in = new ObjectInputStream(fis);
			loadedGame = (Game) in.readObject();
			in.close();
		} catch (IOException ex) {
			throw new UserInputException("Invalid load game file");
		} catch (ClassNotFoundException ex) {
			throw new UserInputException("Invalid load game file");
		}
		if(loadedGame != null)
			loadGame(loadedGame);
	}
	
	/**
	 * Load a game
	 * @param game Game to make active
	 */
	public void loadGame(Game game) {
		this.game = game;
		game.setOwner(this);
		updateScreen();
	}

	/**
	 * Change the current screen to match the location on the map.
	 */
	public void updateScreen() {
		Location cur = game.currentLocation();
		if (cur == null) {
			if(mainPanel instanceof TravelScreen)
				return;
			else
				setPanel(new TravelScreen(this));
		} else if (cur instanceof Shop) {
			setPanel(new ShopScreen(this, (Shop) cur));
		} else if (cur instanceof Landmark) {
			setPanel(new LandmarkScreen(this, (Landmark) cur));
		} else if (cur instanceof Town){
			setPanel(new TownScreen(this, (Town) cur));
		} else if(cur instanceof Crossing){
			setPanel(new CrossingScreen(this, (Crossing) cur));
		}
	}
	
	/**
	 * Clears the game state and goes to the new game screen
	 */
	public void newGame() {
		game = null;
		setPanel(new NewGameScreen(this));
	}

	/**
	 * Set the main app panel
	 * @param p JPanel to set as primary
	 */
	void setPanel(JPanel p) {
		frame.add(p);
		if (mainPanel != null)
			frame.remove(mainPanel);
		mainPanel = p;
		frame.setVisible(true);
	}
	
	/**
	 * Leaves the current location on the map and updates the game screen
	 */
	public void leaveLocation() {
		game.leaveLocation();
		updateScreen();
	}
	
	/**
	 * Get the game's current event listener
	
	 * @return GameEventListener to register with */
	public GameEventListener getListener(){
		return game.getListener();
	}

	/**
	 * Get the current game's wagon
	
	 * @return game wagon */
	public Wagon getWagon() {
		return game.getWagon();
	}
	
	/**
	 * Get the current game's map
	
	 * @return game map */
	public Map getMap() {
		return game.getMap();
	}
	
	/**
	 * Get the current game
	
	 * @return game */
	Game getGame() {
		return game;
	}

	/**
	 * Make the nextDay happen for the entire app and update the screen
	 */
	public void nextDay() {
		game.nextDay(game);
		this.updateScreen();
	}

	/**
	 * Check if the app is ready to continue
	
	 * @return Is the app ready? */
	public boolean isReady() {
		return game.isReady();
	}
}
