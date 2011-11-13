package com.kelsonprime.oregontrail.gui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GUI for the main screen
 */
public class SplashScreen extends JPanel{
	private static final long serialVersionUID = 5914811187310733038L;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static URL splashImage = SplashScreen.class.getResource("/images/OregonTrailStartScreen.jpg");
	
	/**
	 * Create main screen
	 */
	public SplashScreen(){
		super();
		repaint();
		setSize(new Dimension(600, 300));
		setBackground(Color.black);
	}
	
	/**
	 * Draw pretty logo
	 * @param g Graphics
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image startImg;
		try {
			startImg = ImageIO.read(splashImage);
			g.drawImage(startImg, 0, 0, this);
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, "Could not load start screen image", e);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Splash screen draw failed", e);
		}
	}
}
