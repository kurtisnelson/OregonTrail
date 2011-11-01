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
import java.util.Timer;
import java.util.TimerTask;

public class TravelScreen extends JPanel {
	private static final long serialVersionUID = -2616586129314449978L;

	OregonTrail app;
	Wagon wagon;
	JLabel lblTravel;
	JLabel nextLocation;
	int current; //Distance to next location
	JPanel options, options2;
	private int counter; //Used to see when stuff should redraw
	Timer traveler;
	ButtonListener listener;
	Button travel;

	public TravelScreen(OregonTrail app) {
		super();
		this.app = app;
		this.wagon = app.getWagon();
		this.listener = new ButtonListener();
		current = app.getMap().distanceToNext();
		
		setSize(new Dimension(600, 300));

		lblTravel = new JLabel("Stopped.");
		lblTravel.setBounds(114, 22, 56, 15);
		
		travel = new Button(new ImageIcon(TravelScreen.class.getResource("/images/MoveAheadButton.png")));
		travel.setBounds(175, 5, 100, 50);
		travel.setPreferredSize(new Dimension(100, 50));
		travel.setBorder(null);
		travel.setActionCommand("start");

		Button change = new Button(new ImageIcon(TravelScreen.class.getResource("/images/UpdateButton.png")));
		change.setBounds(280, 5, 100, 50);
		change.setPreferredSize(new Dimension(100, 50));
		change.setBorder(null);
		change.setActionCommand("change");

		Button rest = new Button(new ImageIcon(TravelScreen.class.getResource("/images/RestButton.png")));
		rest.setBounds(385, 5, 100, 50);
		rest.setPreferredSize(new Dimension(100, 50));
		rest.setBorder(null);
		rest.setActionCommand("rest");
		rest.addActionListener(listener);
		
		travel.addActionListener(listener);
		change.addActionListener(listener);
		rest.addActionListener(listener);
		setLayout(null);

		//Setup options area.
		options = new JPanel();
		options.setPreferredSize(new Dimension(600, 50));
		options.setBounds(0, 0, 600, 50);
		options.add(lblTravel);
		options.add(travel);
		options.add(change);
		options.add(rest);
		
		this.add(options);
		
		JPanel wagonStats = new JPanel();
		wagonStats.setBounds(66, 175, 200, 50);
		add(wagonStats);
		
		JLabel lblStatPanel = new JLabel("State");
		wagonStats.add(lblStatPanel);
		
		nextLocation = new JLabel("Next: ");
		wagonStats.add(nextLocation);

		updateStats();
		//Setup animation magic
		counter = 0;
	}

	public void paintComponent(Graphics g) {
		Image regBG = new ImageIcon(TravelScreen.class.getResource(
				"/images/OregonTrailTravelingScreenRegular.jpg")).getImage();
		Image wagonA = new ImageIcon(TravelScreen.class.getResource("/images/OregonTrailIcon.png")).getImage();
		g.drawImage(regBG, 5*(counter%5), 0, this);
		g.drawImage(wagonA, 400, 120, this);
	}
	
	/**
	 * Stop automatic traveling
	 */
	private void stopTravel(){
		traveler.cancel();
		travel.setActionCommand("start");
		lblTravel.setText("Stopped");
		updateStats();
	}
	
	/**
	 * Start traveling every 2 seconds
	 */
	private void startTravel(){
		travel.setActionCommand("stop");
		traveler = new Timer("Traveler");
		traveler.scheduleAtFixedRate(new TimerTraveler(), 1, 500);
	}
	
	/**
	 * Travel one day
	 */
	private void travel() {
		lblTravel.setText("Traveling");
		app.nextDay();
		current = app.getMap().distanceToNext();
		updateStats();
		repaint();
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
		nextLocation.setText(app.getMap().nextLocation()+ " is " + Integer.toString(current) + " away.");
	}

	private class TimerTraveler extends TimerTask {
		@Override
		public void run() {
			counter++;
			if(counter % 2 == 0)
				travel();
			else
				repaint();
		}
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if (s.equalsIgnoreCase("start")) {
				Threader.executeNow(new Runnable(){
					@Override
					public void run() {
						startTravel();
					}
				});
			} else if (s.equalsIgnoreCase("stop")) {
				Threader.executeNow(new Runnable(){
					@Override
					public void run() {
						stopTravel();
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
			}
		}
	}
}
