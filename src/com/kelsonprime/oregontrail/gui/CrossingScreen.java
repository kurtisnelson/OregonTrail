package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.kelsonprime.oregontrail.model.Wagon;

public class CrossingScreen extends LocationScreen {
	private static final long serialVersionUID = -2616586129314449978L;

	OregonTrail app;
	Wagon wagon;

	public CrossingScreen(OregonTrail app) {
		super(app);
		this.app = app;
		this.wagon = app.getWagon();
		
		ButtonListener listener = new ButtonListener();
		
		JButton ferry = new JButton("Take a Ferry");
		ferry.setPreferredSize(new Dimension(100, 50));
		ferry.setActionCommand("ferry");
		ferry.addActionListener(listener);
		
		JButton caulk = new JButton("Caulk your Wagon");
		caulk.setPreferredSize(new Dimension(100, 50));
		caulk.setActionCommand("caulk");
		caulk.addActionListener(listener);
		
		JButton wade = new JButton("Wade over the River");
		wade.setPreferredSize(new Dimension(100, 50));
		wade.setActionCommand("wade");
		wade.addActionListener(listener);
		
		
		add(ferry);
		add(caulk);
		add(wade);
	}

	public void paintComponent(Graphics g) {
		Image regBG = new ImageIcon(CrossingScreen.class.getResource(
				"/images/CrossingScreen.jpg")).getImage();
		g.drawImage(regBG, 0, 0, this);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			
			if (s.equalsIgnoreCase("ferry")){
				
			}
			else if (s.equalsIgnoreCase("caulk")){
							
			}
			else if (s.equalsIgnoreCase("wade")){
				
			}
		}
	}
}
