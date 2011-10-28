package com.kelsonprime.oregontrail.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {
	private static final long serialVersionUID = -7346008466805143017L;
	private ImageIcon buttonImage;
	
	public Button(ImageIcon img){
		super();
		buttonImage = img;
		setPreferredSize(new Dimension(100, 50));
		setBackground(new Color(0,0,0,0));
		setOpaque(false);
		setContentAreaFilled(false);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(buttonImage.getImage(), 0, 0, this);
	}
}
