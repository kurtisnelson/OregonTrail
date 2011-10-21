package com.kelsonprime.oregontrail.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class MainMenu extends JMenuBar {
	private static final long serialVersionUID = 4131897710803488227L;

	private MainMenuListener menuListen;

	public MainMenu(OregonTrail app) {
		menuListen = new MainMenuListener(app);
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		this.add(fileMenu);

		JMenuItem newGame = new JMenuItem("New Game");
		newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(newGame);
		fileMenu.add(exit);
		newGame.addActionListener(menuListen);
		newGame.setActionCommand("newGame");
		exit.addActionListener(menuListen);
		exit.setActionCommand("exit");
	}
}
