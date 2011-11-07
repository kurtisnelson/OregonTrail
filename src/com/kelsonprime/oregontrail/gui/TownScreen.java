package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.kelsonprime.oregontrail.model.Shop;

public class TownScreen extends LocationScreen {

	private static final long serialVersionUID = 2954231432340769351L;
	Image img = new ImageIcon(TownScreen.class.getResource("images/tempTown.jpg")).getImage();
	Shop shop;
	
	public TownScreen(OregonTrail app, Shop shop) {
		super(app);
		
		if (shop != null){
			this.shop = shop;
		}
		
		Image shopBtn = new ImageIcon(TownScreen.class.getResource("images/tempShop.jpg")).getImage();
		Image innBtn = new ImageIcon(TownScreen.class.getResource("images/tempInn.jpg")).getImage();
		
		Button shopB = new Button(new ImageIcon(shopBtn));
		shopB.setPreferredSize(new Dimension(100, 100));
		shopB.setActionCommand("shop");
		
		
		Button innB = new Button(new ImageIcon(innBtn));
		innB.setPreferredSize(new Dimension(100, 100));
		innB.setActionCommand("inn");
		
		if (shop != null)
			add(shopB);
		add(innB);

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}
	
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String s = ae.getActionCommand();
			
			if (s.equalsIgnoreCase("shop")){
				//TODO Go to shop
			} else if (s.equalsIgnoreCase("inn")){
				//TODO Rest (in town)
			}
		}
		
	}
	
}
