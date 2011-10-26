package com.kelsonprime.oregontrail.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {
	
	private static final long serialVersionUID = 1L;
	private ImageIcon buttonImage;
	
	public Button(ImageIcon img){
		super();
		buttonImage = img;
		setPreferredSize(new Dimension(100, 50));
		setBackground(new Color(0,0,0,0));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(buttonImage.getImage(), 0, 0, this);
	}
}
