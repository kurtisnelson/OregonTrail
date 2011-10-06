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
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(newGame);
		fileMenu.add(exit);
		newGame.addActionListener(menuListen);
		newGame.setActionCommand("newGame");
		exit.addActionListener(menuListen);
		exit.setActionCommand("exit");
	}
}