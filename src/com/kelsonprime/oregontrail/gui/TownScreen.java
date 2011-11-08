package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.kelsonprime.oregontrail.model.Town;

public class TownScreen extends LocationScreen {

	private static final long serialVersionUID = 2954231432340769351L;
	Image img = new ImageIcon(TownScreen.class.getResource("images/tempTown.jpg")).getImage();
	Town town;
	
	public TownScreen(OregonTrail app, Town town) {
		super(app);
		
		Image shopBtn = new ImageIcon(TownScreen.class.getResource("images/tempShop.jpg")).getImage();
		Image innBtn = new ImageIcon(TownScreen.class.getResource("images/tempInn.jpg")).getImage();
		
		Button shopB = new Button(new ImageIcon(shopBtn));
		shopB.setPreferredSize(new Dimension(100, 100));
		shopB.setActionCommand("shop");
		
		
		Button innB = new Button(new ImageIcon(innBtn));
		innB.setPreferredSize(new Dimension(100, 100));
		innB.setActionCommand("inn");
		
		if (town.getShop() != null)
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
				ShopScreen theShop = new ShopScreen(app, town.getShop());
				//TODO launch shop screen, but return here when done.
			}else if (s.equalsIgnoreCase("inn")){
				app.getGame().rest();
				//TODO Rest (in town)
			}
		}
		
	}
	
}
