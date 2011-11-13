package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.kelsonprime.oregontrail.model.Crossing;
import com.kelsonprime.oregontrail.model.Wagon;
import com.kelsonprime.oregontrail.controller.Events;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GUI for a <code>Crossing</code>
 * @see com.kelsonprime.oregontrail.model.Crossing
 */
public class CrossingScreen extends LocationScreen {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final long serialVersionUID = -2616586129314449978L;

	Wagon wagon;
	Crossing crossing;
	Random rand = new Random();

	/**
	 * Create a new screen
	 * @param app OregonTrail
	 * @param crossing Crossing to cross
	 */
	public CrossingScreen(OregonTrail app, Crossing crossing) {
		super(app);
		this.wagon = app.getWagon();
		this.crossing = crossing;
		
		try{
		background = new ImageIcon(
				CrossingScreen.class.getResource("/images/CrossingScreen.jpg"))
				.getImage();
	}catch(NullPointerException e){
		LOGGER.log(Level.FINE, "Missing resource CrossingScreen.jpg");
		throw new RuntimeException("Missing resource CrossingScreen.jpg");
	}

		ButtonListener listener = new ButtonListener();

		JButton ferry = new JButton("Take a Ferry: $" + crossing.ferry());
		ferry.setPreferredSize(new Dimension(100, 50));
		ferry.setActionCommand("ferry");
		ferry.addActionListener(listener);

		JButton caulk = new JButton("Caulk your Wagon");
		caulk.setLocation(0, 0);
		caulk.setSize(222, 22);
		caulk.setPreferredSize(new Dimension(100, 50));
		caulk.setActionCommand("caulk");
		caulk.addActionListener(listener);

		JButton wade = new JButton("Wade over the River");
		wade.setLocation(0, 22);
		wade.setSize(222, 22);
		wade.setPreferredSize(new Dimension(100, 50));
		wade.setActionCommand("wade");
		wade.addActionListener(listener);

		if (crossing.isFerry())
			add(ferry);
		add(caulk);
		add(wade);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try{
		g.drawImage(
				new ImageIcon(CrossingScreen.class
						.getResource("/images/OregonTrailIcon.jpg")).getImage(),
				400, 100, this);
		}catch(NullPointerException e){
			LOGGER.log(Level.FINE, "Missing resource OregonTrailIcon");
			throw new RuntimeException("Missing resource OregonTrailIcon");
		}
	}

	/**
	 * Select method to cross
	 */
	private class ButtonListener implements ActionListener {

		/**
		 * Method actionPerformed.
		 * @param e ActionEvent
		 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();

			if (s.equalsIgnoreCase("ferry")) {
				wagon.changeMoney((-1) * Integer.valueOf(crossing.ferry())); // 100% Chance Success
			} else if (s.equalsIgnoreCase("caulk")) {
				int success = rand.nextInt(Wagon.MAXWEIGHT);
				if (success <= (wagon.getWeight() * 2 / 3)){
					Events.loseItems(wagon, .25);
				}					
			} else if (s.equalsIgnoreCase("wade")) {
				int success = rand.nextInt(Wagon.MAXWEIGHT);
				if (success <= wagon.getWeight()){
					Events.loseItems(wagon, .5);
				}					
			}
			getApp().leaveLocation();
		}
	}
}
