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
import com.kelsonprime.oregontrail.controller.Map;
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
	int xDist, previous, current, end;
	Timer updateImage;
	JPanel options, options2;
	boolean moving;

	public TravelScreen(OregonTrail app) {
		super();
		this.app = app;
		this.wagon = app.getWagon();
		current = app.getMap().distanceToNext();
		previous = end = current;
		xDist = 0;
		setSize(new Dimension(600, 300));

		lblTravel = new JLabel("TRAVEL!");
		lblTravel.setBounds(114, 22, 56, 15);
		
		options = new JPanel();
		options.setPreferredSize(new Dimension(600, 50));
		options.setBounds(0, 0, 600, 50);
		add(options);
		
		options2 = new JPanel();
		options2.setPreferredSize(new Dimension(600, 50));
		options2.setBounds(0, 0, 600, 50);
		
		Button travel = new Button(new ImageIcon(TravelScreen.class.getResource("/images/MoveAheadButton.png")));
		travel.setBounds(175, 5, 100, 50);
		travel.setPreferredSize(new Dimension(100, 50));
		travel.setBorder(null);
		travel.setActionCommand("travel");

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
		
		Button stop = new Button(new ImageIcon(TravelScreen.class.getResource("/images/MoveAheadButton.png")));
		stop.setBounds(175, 5, 100, 50);
		stop.setPreferredSize(new Dimension(100, 500));
		stop.setBorder(null);
		stop.setActionCommand("stop");

		ButtonListener listen = new ButtonListener();
		travel.addActionListener(listen);
		change.addActionListener(listen);
		rest.addActionListener(listen);
		setLayout(null);

		options.add(lblTravel);
		options.add(travel);
		options.add(change);
		options.add(rest);
		options2.add(stop);
		
		JPanel wagonStats = new JPanel();
		wagonStats.setBounds(66, 175, 200, 50);
		add(wagonStats);
		
		JLabel lblStatPanel = new JLabel("State");
		wagonStats.add(lblStatPanel);
		
		nextLocation = new JLabel("Next: ");
		wagonStats.add(nextLocation);
		
		updateImage = new Timer(500, listen);
		updateImage.setActionCommand("image");

		updateStats();
		moving=false;
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Image regBG = new ImageIcon(TravelScreen.class.getResource(
				"/images/OregonTrailTravelingScreenRegular.jpg")).getImage();
		Image wagonA = new ImageIcon(TravelScreen.class.getResource("/images/OregonTrailIcon.png")).getImage();
		g.drawImage(regBG, -1500-(current*5), 0, this);
		g.drawImage(wagonA, 400, 120, this);
	}
	
	public void backgroundMove(){
		current--;
		if (current!=end){
			moving = true;
		}
		else
			moving = false;
	}
	
	

	/**
	 * Travel one day
	 */
	private void travel() {
		Map map = app.getMap();
		lblTravel.setText("Traveling a day");
		previous = map.distanceToNext();
		current = previous;
		app.nextDay();
		end = map.distanceToNext();
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
		nextLocation.setText(app.getMap().nextLocation()+ " is " + Integer.toString(current) + " away.");
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if (s.equalsIgnoreCase("travel")) {
//				Threader.executeNow(new Runnable(){
//					@Override
//					public void run() {
//						travel();
//					}
//				});
				remove(options);
				add(options2);
				repaint();
				updateImage.start();
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
		//		Threader.executeEventually(new Runnable(){
			//		public void run(){
						if(!moving){
							travel();
						}
						backgroundMove();
						updateStats();
						repaint();
			//		}
			//	});
			} else if (s.equalsIgnoreCase("stop")){
				remove(options2);
				add(options);
				updateImage.stop();
			}
		}
	}
}
