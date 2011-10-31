package com.kelsonprime.oregontrail.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.kelsonprime.oregontrail.model.Wagon;

public class CrossingScreen extends JPanel {
	private static final long serialVersionUID = -2616586129314449978L;

	OregonTrail app;
	Wagon wagon;

	public CrossingScreen(OregonTrail app) {
		super();
		this.app = app;
		this.wagon = app.getWagon();
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
		}
	}
}
