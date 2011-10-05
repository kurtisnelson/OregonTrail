package com.kelsonprime.oregontrail.gui;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JMenuBar {
	
	private MainMenuListener menuListen;
	
	public MainMenu(OregonTrail app){
		menuListen = new MainMenuListener(app);
		JMenu fileMenu = new JMenu("File");
		this.add(fileMenu);
		
		JMenuItem newGame = new JMenuItem("New Game");
		fileMenu.add(newGame);
		newGame.addActionListener(menuListen);
		newGame.setActionCommand("newGame");
	}
}