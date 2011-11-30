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
import javax.swing.JOptionPane;

import com.kelsonprime.oregontrail.controller.IconFactory;
import com.kelsonprime.oregontrail.model.Town;

/**
 * GUI for a <code>Town</code>
 * @see com.kelsonprime.oregontrail.model.Town
 */
public class TownScreen extends LocationScreen {

	private static final long serialVersionUID = 2954231432340769351L;
	Town town;
	Button shopB, innB, change;
	
	/**
	 * Constructor for TownScreen.
	 * @param app OregonTrail
	 * @param town Town
	 */
	public TownScreen(OregonTrail app, Town town) {
		super(app);
		
		this.town = town;
		
		ButtonListener bl = new ButtonListener();
		
		shopB = new Button(new ImageIcon(TownScreen.class.getResource("/images/tempShop.png")));
		shopB.addActionListener(bl);
		shopB.setPreferredSize(new Dimension(100, 100));
		shopB.setSize(100, 100);
		shopB.setActionCommand("shop");
		shopB.setBorder(null);
		
		Button innB = new Button(new ImageIcon(TownScreen.class.getResource("/images/tempInn.png")));
		innB.setBounds(300, 140, 100, 100);
		innB.setPreferredSize(new Dimension(100, 100));
		innB.addActionListener(bl);
		innB.setActionCommand("inn");
		innB.setBorder(null);
		
		if (town.getShop() != null)
			this.add(shopB);
		this.add(innB);
		
		JButton leaveButton = new JButton();
		leaveButton.setBounds(492, 246, 50, 22);
		leaveButton.setBackground(Color.WHITE);
		leaveButton.setOpaque(false);
		leaveButton.setBorderPainted(false);
		leaveButton.setRolloverEnabled(false);
		leaveButton.setIcon(new ImageIcon(TownScreen.class.getResource("/images/arrow.png")));
		leaveButton.setMnemonic('n');
		this.add(leaveButton);
		
		leaveButton.setActionCommand("leave");
		leaveButton.addActionListener(bl);

	}

	/**
	 * Method paintComponent.
	 * @param g Graphics
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(new ImageIcon(TownScreen.class.getResource("/images/tempTown.jpg")).getImage(), 0, 0, this);
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
				JOptionPane.showMessageDialog(null, "You rest at the inn and your party members feel much healithier!");
				//TODO Rest (in town)
			} else if (s.equalsIgnoreCase("leave")){
				getApp().leaveLocation();
			}
		}
		
	}
	
}
