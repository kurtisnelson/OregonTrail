package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Generic GUI for <code>Location</code>
 * @see com.kelsonprime.oregontrail.model.Location
 * @author Kurt
 */
public abstract class LocationScreen extends JPanel {
	protected Image background;
	private static final long serialVersionUID = 2247264002726443781L;
	private OregonTrail app;

	/**
	 * Create generic Location GUI
	 * @param app OregonTrail
	 */
	public LocationScreen(OregonTrail app) {
		this.app = app;
		background = new ImageIcon(LocationScreen.class.getResource("/images/dirt.jpg")).getImage();
		Dimension size = new Dimension(OregonTrail.WIDTH, OregonTrail.HEIGHT);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	/**
	 * Get the application that owns this
	 * @return OregonTrail
	 */
	protected OregonTrail getApp(){
		return app;
	}

	/**
	 * Draw the background
	 * @param g Graphics
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}