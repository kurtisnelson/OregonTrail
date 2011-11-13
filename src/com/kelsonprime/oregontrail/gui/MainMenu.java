package com.kelsonprime.oregontrail.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

/**
 * Application's main menu
 */
public class MainMenu extends JMenuBar {
	private static final long serialVersionUID = 4131897710803488227L;
	private MainMenuListener menuListen;

	/**
	 * Create main menu
	 * @param app OregonTrail
	 */
	public MainMenu(OregonTrail app) {
		menuListen = new MainMenuListener(app);
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		this.add(fileMenu);

		JMenuItem newGame = new JMenuItem("New Game");
		newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		newGame.addActionListener(menuListen);
		newGame.setActionCommand("newGame");
		fileMenu.add(newGame);
		
		JMenuItem saveGame = new JMenuItem("Save Game");
		saveGame.addActionListener(menuListen);
		saveGame.setActionCommand("saveGame");
		fileMenu.add(saveGame);
		
		JMenuItem loadGame = new JMenuItem("Load Game");
		loadGame.addActionListener(menuListen);
		loadGame.setActionCommand("loadGame");
		fileMenu.add(loadGame);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(menuListen);
		exit.setActionCommand("exit");
		fileMenu.add(exit);
	}
}
