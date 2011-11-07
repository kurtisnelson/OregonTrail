package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class TownScreen extends LocationScreen {

	private static final long serialVersionUID = 2954231432340769351L;
	Image img = new ImageIcon(TownScreen.class.getResource("images/tempTown.jpg")).getImage();
	
	public TownScreen(OregonTrail app) {
		super(app);
		
		Image shopBtn = new ImageIcon(TownScreen.class.getResource("images/tempShop.jpg")).getImage();
		Image innBtn = new ImageIcon(TownScreen.class.getResource("images/tempInn.jpg")).getImage();
		
		Button shop = new Button(new ImageIcon(shopBtn));
		shop.setPreferredSize(new Dimension(100, 100));
		Button inn = new Button(new ImageIcon(innBtn));
		inn.setPreferredSize(new Dimension(100, 100));
		
		add(shop);
		add(inn);

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}
	
}
