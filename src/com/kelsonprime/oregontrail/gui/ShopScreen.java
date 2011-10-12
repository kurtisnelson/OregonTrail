package com.kelsonprime.oregontrail.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.model.Shop;
import com.kelsonprime.oregontrail.model.Wagon;

public class ShopScreen extends LocationScreen {
	private static final long serialVersionUID = -7550296665413775236L;
	private static final String CURRENCY = "$";
	private Shop shop;
	private Wagon wagon;
	private JTextField oxenQuantity;
	private JTextField axleQuantity;
	private JTextField wheelQuantity;
	private JTextField tongueQuantity;
	private JTextField clothesQuantity;
	private JTextField bulletQuantity;
	private JTextField foodQuantity;

	public ShopScreen(Game game, Shop shop) {
		super(game);
		this.shop = shop;
		this.wagon = game.getWagon();
		setSize(new Dimension(600, 300));
		setLayout(new BorderLayout(0, 0));
		
		ButtonListener listener = new ButtonListener();

		JPanel header = new JPanel();
		header.setBackground(UIManager
				.getColor("OptionPane.warningDialog.titlePane.foreground"));
		header.setForeground(UIManager
				.getColor("OptionPane.warningDialog.titlePane.foreground"));
		add(header, BorderLayout.NORTH);

		JLabel screenLabel = new JLabel("Welcome to the " + shop.label()
				+ " Shop");
		screenLabel.setLabelFor(header);
		screenLabel.setForeground(Color.WHITE);
		header.add(screenLabel);

		JPanel body = new JPanel();
		body.setBackground(UIManager
				.getColor("OptionPane.warningDialog.titlePane.shadow"));
		body.setForeground(UIManager
				.getColor("OptionPane.warningDialog.titlePane.shadow"));
		add(body, BorderLayout.CENTER);
		body.setLayout(null);

		axleQuantity = new JTextField();
		axleQuantity.setText("0");
		axleQuantity.setBounds(410, 43, 88, 19);
		body.add(axleQuantity);
		axleQuantity.setColumns(10);

		oxenQuantity = new JTextField();
		oxenQuantity.setText("0");
		oxenQuantity.setBounds(410, 12, 88, 19);
		body.add(oxenQuantity);
		oxenQuantity.setColumns(10);

		wheelQuantity = new JTextField();
		wheelQuantity.setText("0");
		wheelQuantity.setBounds(410, 74, 88, 19);
		body.add(wheelQuantity);
		wheelQuantity.setColumns(10);

		tongueQuantity = new JTextField();
		tongueQuantity.setText("0");
		tongueQuantity.setBounds(410, 105, 88, 19);
		body.add(tongueQuantity);
		tongueQuantity.setColumns(10);

		clothesQuantity = new JTextField();
		clothesQuantity.setText("0");
		clothesQuantity.setBounds(410, 136, 88, 19);
		body.add(clothesQuantity);
		clothesQuantity.setColumns(10);

		bulletQuantity = new JTextField();
		bulletQuantity.setText("0");
		bulletQuantity.setBounds(410, 168, 88, 19);
		body.add(bulletQuantity);
		bulletQuantity.setColumns(10);

		foodQuantity = new JTextField();
		foodQuantity.setText("0");
		foodQuantity.setBounds(410, 201, 88, 19);
		body.add(foodQuantity);
		foodQuantity.setColumns(10);

		JLabel oxenLabel = new JLabel("Oxen");
		oxenLabel.setBounds(375, 16, 41, 15);
		body.add(oxenLabel);

		JLabel axleLabel = new JLabel("Axle");
		axleLabel.setBounds(382, 45, 34, 15);
		body.add(axleLabel);

		JLabel wheelLabel = new JLabel("Wheels");
		wheelLabel.setBounds(358, 75, 53, 17);
		body.add(wheelLabel);

		JLabel tongueLabel = new JLabel("Tongues");
		tongueLabel.setBounds(349, 107, 61, 15);
		body.add(tongueLabel);

		JLabel clothLabel = new JLabel("Clothes");
		clothLabel.setBounds(355, 138, 61, 15);
		body.add(clothLabel);

		JLabel bulletsLabel = new JLabel("Bullets (10/box)");
		bulletsLabel.setBounds(302, 170, 108, 15);
		body.add(bulletsLabel);

		JLabel foodLabel = new JLabel("Food (lbs)");
		foodLabel.setBounds(340, 203, 70, 15);
		body.add(foodLabel);

		JLabel axlePrice = new JLabel(CURRENCY + shop.axlePrice());
		axlePrice.setBounds(506, 45, 61, 15);
		body.add(axlePrice);

		JLabel wheelPrice = new JLabel(CURRENCY + shop.wheelPrice());
		wheelPrice.setBounds(505, 76, 61, 15);
		body.add(wheelPrice);

		JLabel oxenPrice = new JLabel(CURRENCY + shop.oxenPrice());
		oxenPrice.setBounds(506, 14, 70, 15);
		body.add(oxenPrice);

		JLabel tonguePrice = new JLabel(CURRENCY + shop.tonguePrice());
		tonguePrice.setBounds(506, 107, 70, 15);
		body.add(tonguePrice);

		JLabel clothesPrice = new JLabel(CURRENCY + shop.clothesPrice());
		clothesPrice.setBounds(506, 138, 70, 15);
		body.add(clothesPrice);

		JLabel bulletPrice = new JLabel(CURRENCY + shop.bulletPrice());
		bulletPrice.setBounds(506, 170, 70, 15);
		body.add(bulletPrice);

		JLabel foodPrice = new JLabel(CURRENCY + shop.foodPrice());
		foodPrice.setBounds(506, 203, 70, 15);
		body.add(foodPrice);

		JButton buyButton = new JButton("Buy Items");
		buyButton.setBounds(320, 232, 117, 25);
		body.add(buyButton);
		buyButton.setActionCommand("buy");
		buyButton.addActionListener(listener);

		JButton leaveButton = new JButton("Leave Shop");
		leaveButton.setBounds(450, 232, 117, 25);
		body.add(leaveButton);
		leaveButton.setActionCommand("leave");
		leaveButton.addActionListener(listener);

		JLabel moneyLabel = new JLabel("Money: $" + wagon.getMoney());
		moneyLabel.setBounds(12, 14, 154, 15);
		body.add(moneyLabel);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String s = ae.getActionCommand();
			if (s.equals("buy")) {
				// TODO mutate Wagon based on Shop
				try{
					Integer.valueOf(axleQuantity.getText());
					Integer.valueOf(wheelQuantity.getText());
					Integer.valueOf(tongueQuantity.getText());
					Integer.valueOf(oxenQuantity.getText());
					Integer.valueOf(clothesQuantity.getText());
					Integer.valueOf(bulletQuantity.getText());
					Integer.valueOf(foodQuantity.getText());
				} catch (java.lang.NumberFormatException e){
					
				}
				shop.sellItem();
			} else if (s.equals("leave")) {
				// TODO Leave store and return to town
			}
		}

	}
}
