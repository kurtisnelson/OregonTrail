package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class LocationScreen extends JPanel {
	private Image background;
	private static final long serialVersionUID = 2247264002726443781L;
	protected OregonTrail app;

	public LocationScreen(OregonTrail app) {
		this.app = app;
		background = new ImageIcon(LocationScreen.class.getResource("/images/dirt.jpg")).getImage();
		Dimension size = new Dimension(background.getWidth(null),
				background.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}