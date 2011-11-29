// $codepro.audit.disable numericLiterals
package com.kelsonprime.oregontrail.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.kelsonprime.oregontrail.controller.IconFactory;
import com.kelsonprime.oregontrail.model.Town;

/**
 * GUI for a <code>Town</code>
 * @see com.kelsonprime.oregontrail.model.Town
 */
public class TownScreen extends LocationScreen {

	private static final long serialVersionUID = 2954231432340769351L;
	Image img = new ImageIcon(TownScreen.class.getResource("images/tempTown.jpg")).getImage();
	Town town;
	
	/**
	 * Constructor for TownScreen.
	 * @param app OregonTrail
	 * @param town Town
	 */
	public TownScreen(OregonTrail app, Town town) {
		super(app);
		
		Image shopBtn = new ImageIcon(TownScreen.class.getResource("images/tempShop.jpg")).getImage();
		Image innBtn = new ImageIcon(TownScreen.class.getResource("images/tempInn.jpg")).getImage();
		
		ButtonListener bl = new ButtonListener();
		
		Button shopB = new Button(new ImageIcon(shopBtn));
		shopB.addActionListener(bl);
		shopB.setPreferredSize(new Dimension(100, 100));
		shopB.setActionCommand("shop");
		
		
		Button innB = new Button(new ImageIcon(innBtn));
		innB.setBounds(0, 76, 81, -76);
		innB.setPreferredSize(new Dimension(100, 100));
		innB.addActionListener(bl);
		innB.setActionCommand("inn");
		
		if (town.getShop() != null)
			add(shopB);
		add(innB);
		
		JButton leaveButton = new JButton();
		leaveButton.setLocation(160, 12);
		leaveButton.setSize(50, 22);
		leaveButton.setBackground(Color.WHITE);
		leaveButton.setOpaque(false);
		leaveButton.setBorderPainted(false);
		leaveButton.setRolloverEnabled(false);
		leaveButton.setSelectedIcon(IconFactory.arrow());
		leaveButton.setIcon(new ImageIcon(ShopScreen.class.getResource("/images/arrow.png")));
		leaveButton.setMnemonic('n');
		add(leaveButton);
		leaveButton.setActionCommand("leave");
		leaveButton.addActionListener(bl);

	}

	/**
	 * Method paintComponent.
	 * @param g Graphics
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}
	
	/**
	 */
	private class ButtonListener implements ActionListener {

		/**
		 * Method actionPerformed.
		 * @param ae ActionEvent
		 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent ae) {
			String s = ae.getActionCommand();
			
			if (s.equalsIgnoreCase("shop")){
				ShopScreen theShop = new ShopScreen(getApp(), town.getShop());
				getApp().setPanel(theShop);
				//TODO launch shop screen, but return here when done.
			} else if (s.equalsIgnoreCase("inn")){
				getApp().getGame().rest();
				//TODO Rest (in town)
			} else if (s.equalsIgnoreCase("leave")){
				getApp().leaveLocation();
			}
		}
		
	}
	
}
