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

import java.util.Timer;
import java.util.TimerTask;

public class TravelScreen extends JPanel {
	private static final long serialVersionUID = -2616586129314449978L;

	private OregonTrail app;
	private JLabel lblTravel;
	private JLabel nextLocation;
	private int current; //Distance to next location
	private JPanel options;
	private int counter; //Used to see when stuff should redraw
	private TravelerTimer traveler;
	private ButtonListener listener;
	private Button travel;
	private Button change;
	private Button rest;
	private static final ImageIcon disabledIcon = new ImageIcon();
	private static final ImageIcon stopIcon = new ImageIcon();
	private static final ImageIcon moveAheadIcon = new ImageIcon(TravelScreen.class.getResource("/images/MoveAheadButton.png"));

	public TravelScreen(OregonTrail app) {
		super();
		this.app = app;
		
		this.listener = new ButtonListener();
		current = app.getMap().distanceToNext();
		
		setSize(new Dimension(600, 300));

		lblTravel = new JLabel("Stopped.");
		lblTravel.setBounds(114, 22, 56, 15);
		
		travel = new Button(moveAheadIcon);
		travel.setBounds(175, 5, 100, 50);
		travel.setPreferredSize(new Dimension(100, 50));
		travel.setBorder(null);
		travel.setActionCommand("start");
		travel.addActionListener(listener);

		change = new Button(new ImageIcon(TravelScreen.class.getResource("/images/UpdateButton.png")));
		change.setDisabledIcon(TravelScreen.disabledIcon);
		change.setBounds(280, 5, 100, 50);
		change.setPreferredSize(new Dimension(100, 50));
		change.setBorder(null);
		change.setActionCommand("change");
		change.addActionListener(listener);

		rest = new Button(new ImageIcon(TravelScreen.class.getResource("/images/RestButton.png")));
		rest.setDisabledIcon(TravelScreen.disabledIcon);
		rest.setBounds(385, 5, 100, 50);
		rest.setPreferredSize(new Dimension(100, 50));
		rest.setBorder(null);
		rest.setActionCommand("rest");
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
		g.drawImage(regBG, 5*(counter%4), 0, this);
		g.drawImage(wagonA, 400, 120, this);
	}
	
	/**
	 * Stop automatic traveling
	 */
	private void stopTravel(){
		try{
			traveler.cancel();
		}catch(Exception e){
			//harmless, we've already cancelled it somewhere else
		}
		change.setEnabled(true);
		travel.setIcon(TravelScreen.moveAheadIcon);
		travel.setActionCommand("start");
		lblTravel.setText("Stopped");
		updateStats();
	}
	
	/**
	 * Start traveling every 2 seconds
	 */
	private void startTravel(){
		travel.setActionCommand("stop");
		travel.setIcon(TravelScreen.stopIcon);
		change.setEnabled(false);
		lblTravel.setText("Traveling");
		traveler = new TravelerTimer();
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
		stopTravel(); //Make sure if we were moving we stop.
		Game g = app.getGame();
		Pace oldPace = g.getPace();
		g.setPace(Pace.STOPPED);
		app.nextDay();
		g.setPace(oldPace);
		lblTravel.setText("Rested a day");
		updateStats();
	}
	
	/**
	 * Update on screen stats about the wagon.
	 */
	private void updateStats(){
		nextLocation.setText(app.getMap().nextLocation()+ " is " + Integer.toString(current) + " away.");
	}
	
	/**
	 * Makes the game nextDay() every two seconds and animates every half-second.
	 * @author Kurt Nelson
	 * @version 1
	 */
	private class TravelerTimer extends Timer {
		public TravelerTimer(){
			super("Traveler");
			this.schedule(new TravelerTimerTask(), 1, 500);
		}
		
		/**
		 * Every fourth run(), travel() and counter++, otherwise adds to the animation counter and requests a redraw.
		 * @author Kurt Nelson
		 * @version 1
		 */
		private class TravelerTimerTask extends TimerTask {

			@Override
			public void run() {
				counter++;
				if(counter % 4 == 0)
					travel();
				else
					repaint();
			}
			
		}
		
	}
	
	/**
	 * Handles Button presses on <code>TravelScreen</code>
	 * @author Kurt Nelson
	 * @version 1
	 */
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
