package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.Pace;
import com.kelsonprime.oregontrail.controller.Threader;
import com.kelsonprime.oregontrail.model.Wagon;
import javax.swing.Timer;

public class TravelScreen extends JPanel {
	private static final long serialVersionUID = -2616586129314449978L;

	OregonTrail app;
	Wagon wagon;
	JLabel lblTravel;
	JLabel nextLocation;
	int xDist, previous, current;

	public TravelScreen(OregonTrail app) {
		super();
		this.app = app;
		this.wagon = app.getWagon();
		xDist = 0;
		setSize(new Dimension(600, 300));

		lblTravel = new JLabel("TRAVEL!");
		lblTravel.setBounds(114, 22, 56, 15);

		Button travel = new Button(new ImageIcon("images/MoveAheadButton.png"));
		travel.setBounds(175, 5, 100, 50);
		travel.setPreferredSize(new Dimension(100, 50));
		travel.setBorder(null);
		travel.setActionCommand("travel");

		Button change = new Button(new ImageIcon("images/UpdateButton.png"));
		change.setBounds(280, 5, 100, 50);
		change.setPreferredSize(new Dimension(100, 50));
		change.setBorder(null);
		change.setActionCommand("change");

		Button rest = new Button(new ImageIcon("images/RestButton.png"));
		rest.setBounds(385, 5, 100, 50);
		rest.setPreferredSize(new Dimension(100, 50));
		rest.setBorder(null);
		rest.setActionCommand("rest");

		ButtonListener listen = new ButtonListener();
		travel.addActionListener(listen);
		change.addActionListener(listen);
		rest.addActionListener(listen);
		setLayout(null);

		add(lblTravel);
		add(travel);
		add(change);
		add(rest);
		
		JPanel wagonStats = new JPanel();
		wagonStats.setBounds(66, 175, 200, 50);
		add(wagonStats);
		
		JLabel lblStatPanel = new JLabel("State");
		wagonStats.add(lblStatPanel);
		
		nextLocation = new JLabel("Next: ");
		wagonStats.add(nextLocation);
		
		Timer updateImage = new Timer(100, listen);
		updateImage.setActionCommand("image");

		
		updateStats();
	}

	public void paintComponent(Graphics g) {
		Image regBG = new ImageIcon(
				"images/OregonTrailTravelingScreenRegular.jpg").getImage();
		Image wagonA = new ImageIcon("images/OregonTrailIcon.png").getImage();
		g.drawImage(regBG, -1500 + xDist, 0, this);
		g.drawImage(wagonA, 400, 120, this);
	}
	
	public void backgroundMove(){
		
	}
	
	

	/**
	 * Travel one day
	 */
	private void travel() {
		lblTravel.setText("Traveling a day");
		app.nextDay();
		updateStats();
	}

	/**
	 * Switch to the game conditions screen.
	 */
	private void changeSettings() {
		lblTravel.setText("You updated your Conditions!");
		// TODO pop window
		updateStats();
	}

	/**
	 * Rest for one day
	 */
	private void rest() {
		lblTravel.setText("Resting a day");
		Game g = app.getGame();
		Pace oldPace = g.getPace();
		g.setPace(Pace.STOPPED);
		app.nextDay();
		g.setPace(oldPace);
		updateStats();
	}
	
	/**
	 * Update on screen stats about the wagon.
	 */
	private void updateStats(){
		nextLocation.setText(app.getMap().nextLocation()+ " is " + app.getMap().distanceToNext() + " away.");
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if (s.equalsIgnoreCase("travel")) {
				Threader.executeNow(new Runnable(){
					@Override
					public void run() {
						travel();
					}
				});
			} else if (s.equalsIgnoreCase("change")) {
				Threader.executeNow(new Runnable(){
					@Override
					public void run() {
						changeSettings();
					}
				});
			} else if (s.equalsIgnoreCase("rest")) {
				Threader.executeNow(new Runnable(){
					@Override
					public void run() {
						rest();
					}
				});
			} else if (s.equalsIgnoreCase("image")) {
				Threader.executeEventually(new Runnable(){
					public void run(){
						backgroundMove();
						repaint();
					}
				});
			}
		}
	}
}
