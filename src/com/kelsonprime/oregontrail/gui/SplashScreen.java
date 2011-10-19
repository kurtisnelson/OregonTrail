package com.kelsonprime.oregontrail.gui;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;

public class SplashScreen extends JPanel{

	public SplashScreen(){
		super();
		repaint();
		setSize(new Dimension(600, 300));
		setBackground(Color.black);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ImageIcon start = new ImageIcon("images/OregonTrailStartScreen.jpg");
		Image startImg = start.getImage();
		
		g.drawImage(startImg, 0, 13, this);
	}
}
