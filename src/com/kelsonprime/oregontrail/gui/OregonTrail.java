package com.kelsonprime.oregontrail.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This class is going to be the main game. It is in charge of owning the parent JFrame, and adding the initial menu to it
 * @author kurt
 *
 */
public class OregonTrail{
	
	public static void main(String[] args){
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem newGame = new JMenuItem("New Game");
		
		fileMenu.add(newGame);
		
		MenuListener menuListen = new MenuListener();
		newGame.addActionListener(menuListen);
		
		
		JFrame frame = new JFrame("Oregon Trail");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);
		
		//frame.add(p);
		frame.pack();
		frame.setVisible(true);
	}		
}