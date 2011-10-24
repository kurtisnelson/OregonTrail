package com.kelsonprime.oregontrail.controller;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {
	
	private ImageIcon buttonImage;
	
	public Button(ImageIcon img){
		buttonImage = img;
		setPreferredSize(new Dimension(100, 50));
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(buttonImage.getImage(), 0, 0, this);
	}
}
