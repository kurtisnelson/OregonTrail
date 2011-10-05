package com.kelsonprime.oregontrail.gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This class is going to be the main game. It is in charge of owning the parent JFrame, and adding the initial menu to it
 * @author kurt
 *
 */
public class OregonTrail{
	
	private static JFrame frame;
	
	private static class MenuListener implements ActionListener, ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("newGame")){
				JPanel newGameFrame = new NewGameScreen();
				frame.add(newGameFrame);
				frame.pack();
			}
			
		}
	}
	
	public static void main(String[] args){
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem newGame = new JMenuItem("New Game");
		
		fileMenu.add(newGame);
		
		MenuListener menuListen = new MenuListener();
		
		newGame.addActionListener(menuListen);
		newGame.setActionCommand("newGame");
		
		
		frame = new JFrame("Oregon Trail");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);
		
		//frame.add(p);
		frame.pack();
		frame.setSize(new Dimension(600, 300));
		frame.setVisible(true);
	}		

}