package com.kelsonprime.oregontrail.gui;

import com.kelsonprime.oregontrail.logic.Game;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This class is going to be the main game. It is in charge of owning the parent
 * JFrame, and adding the initial menu to it
 * 
 * @author kurt
 * 
 */
public class OregonTrail {
	Game game;
	JMenuBar mainMenu;

	private static JFrame frame;

	private static class MenuListener implements ActionListener, ItemListener {
		OregonTrail app;

		public MenuListener(OregonTrail app) {
			this.app = app;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("newGame")) {
				app.newGameScreen();
			}

		}
	}

	public void newGameScreen(){
		JPanel newGameFrame = new NewGameScreen(this);
		frame.add(newGameFrame);
		frame.pack();
	}
	
	public static void main(String[] args) {
		OregonTrail app = new OregonTrail();
	}

	public OregonTrail() {
		this.mainMenu = new MainMenu();
		JMenu fileMenu = new JMenu("File");
		mainMenu.add(fileMenu);

		JMenuItem newGame = new JMenuItem("New Game");

		fileMenu.add(newGame);

		MenuListener menuListen = new MenuListener(this);

		newGame.addActionListener(menuListen);
		newGame.setActionCommand("newGame");

		frame = new JFrame("Oregon Trail");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(mainMenu);

		// frame.add(p);
		frame.pack();
		frame.setSize(new Dimension(600, 300));
		frame.setVisible(true);
	}

	public void setGame(Game game) {
		this.game = game;
	}
}