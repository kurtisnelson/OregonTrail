package com.kelsonprime.oregontrail.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.model.Shop;
import com.kelsonprime.oregontrail.model.Wagon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

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

		ButtonListener listener = new ButtonListener();
		setLayout(null);

		JPanel header = new JPanel();
		header.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, null, null));
		header.setBounds(156, 5, 350, 30);
		header.setBackground(new Color(184, 134, 11));
		add(header);
		header.setLayout(null);

		JLabel screenLabel = new JLabel(shop.label() + " Shop");
		screenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		screenLabel.setBounds(0, 5, 350, 20);
		screenLabel.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		screenLabel.setLabelFor(header);
		screenLabel.setForeground(Color.BLACK);
		header.add(screenLabel);

		JPanel items = new JPanel();
		items.setBackground(new Color(222, 184, 135));
		items.setBounds(268, 40, 304, 248);
		items.setOpaque(false);
		add(items);
		items.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel oxenLabel = new JLabel("Oxen");
		items.add(oxenLabel);
		
				oxenQuantity = new JTextField();
				oxenQuantity.setHorizontalAlignment(SwingConstants.CENTER);
				oxenLabel.setLabelFor(oxenQuantity);
				oxenQuantity.setText("0");
				items.add(oxenQuantity);
				oxenQuantity.setColumns(3);
		
				JLabel oxenPrice = new JLabel(CURRENCY + shop.oxenPrice());
				oxenPrice.setFont(new Font("STIXGeneral", Font.PLAIN, 14));
				oxenPrice.setHorizontalAlignment(SwingConstants.CENTER);
				items.add(oxenPrice);
		
				JLabel axleLabel = new JLabel("Axle");
				items.add(axleLabel);
		
				axleQuantity = new JTextField();
				axleQuantity.setHorizontalAlignment(SwingConstants.CENTER);
				axleLabel.setLabelFor(axleQuantity);
				axleQuantity.setText("0");
				items.add(axleQuantity);
				axleQuantity.setColumns(3);
		
				JLabel axlePrice = new JLabel(CURRENCY + shop.axlePrice());
				axlePrice.setFont(new Font("STIXGeneral", Font.PLAIN, 14));
				axlePrice.setHorizontalAlignment(SwingConstants.CENTER);
				items.add(axlePrice);
		
				JLabel wheelLabel = new JLabel("Wheels");
				items.add(wheelLabel);
		
				wheelQuantity = new JTextField();
				wheelQuantity.setHorizontalAlignment(SwingConstants.CENTER);
				wheelLabel.setLabelFor(wheelQuantity);
				wheelQuantity.setText("0");
				items.add(wheelQuantity);
				wheelQuantity.setColumns(3);
		
				JLabel wheelPrice = new JLabel(CURRENCY + shop.wheelPrice());
				wheelPrice.setFont(new Font("STIXGeneral", Font.PLAIN, 14));
				wheelPrice.setHorizontalAlignment(SwingConstants.CENTER);
				items.add(wheelPrice);
		
				JLabel tongueLabel = new JLabel("Tongues");
				items.add(tongueLabel);
		
				tongueQuantity = new JTextField();
				tongueQuantity.setHorizontalAlignment(SwingConstants.CENTER);
				tongueLabel.setLabelFor(tongueQuantity);
				tongueQuantity.setText("0");
				items.add(tongueQuantity);
				tongueQuantity.setColumns(3);
		
				JLabel tonguePrice = new JLabel(CURRENCY + shop.tonguePrice());
				tonguePrice.setFont(new Font("STIXGeneral", Font.PLAIN, 14));
				tonguePrice.setHorizontalAlignment(SwingConstants.CENTER);
				items.add(tonguePrice);
				
						JLabel clothLabel = new JLabel("Clothes");
						items.add(clothLabel);
		
				clothesQuantity = new JTextField();
				clothesQuantity.setHorizontalAlignment(SwingConstants.CENTER);
				clothLabel.setLabelFor(clothesQuantity);
				clothesQuantity.setText("0");
				items.add(clothesQuantity);
				clothesQuantity.setColumns(3);
		
				JLabel clothesPrice = new JLabel(CURRENCY + shop.clothesPrice());
				clothesPrice.setFont(new Font("STIXGeneral", Font.PLAIN, 14));
				clothesPrice.setHorizontalAlignment(SwingConstants.CENTER);
				items.add(clothesPrice);
		
				JLabel bulletsLabel = new JLabel("Bullets (x10)");
				items.add(bulletsLabel);
		
				bulletQuantity = new JTextField();
				bulletQuantity.setHorizontalAlignment(SwingConstants.CENTER);
				bulletsLabel.setLabelFor(bulletQuantity);
				bulletQuantity.setText("0");
				items.add(bulletQuantity);
				bulletQuantity.setColumns(3);
		
				JLabel bulletPrice = new JLabel(CURRENCY + shop.bulletPrice());
				bulletPrice.setFont(new Font("STIXGeneral", Font.PLAIN, 14));
				bulletPrice.setHorizontalAlignment(SwingConstants.CENTER);
				items.add(bulletPrice);
		
				JLabel foodLabel = new JLabel("Food (lbs)");
				items.add(foodLabel);
		
				foodQuantity = new JTextField();
				foodQuantity.setHorizontalAlignment(SwingConstants.CENTER);
				foodLabel.setLabelFor(foodQuantity);
				foodQuantity.setText("0");
				items.add(foodQuantity);
				foodQuantity.setColumns(3);
		
				JLabel foodPrice = new JLabel(CURRENCY + shop.foodPrice());
				foodPrice.setFont(new Font("STIXGeneral", Font.PLAIN, 14));
				foodPrice.setHorizontalAlignment(SwingConstants.CENTER);
				items.add(foodPrice);
		
		JLabel blank = new JLabel();
		items.add(blank);
		
				JButton buyButton = new JButton("Buy");
				buyButton.setMnemonic('b');
				items.add(buyButton);
				buyButton.setActionCommand("buy");
				buyButton.addActionListener(listener);
		
				JButton leaveButton = new JButton();
				leaveButton.setBackground(Color.WHITE);
				leaveButton.setOpaque(false);
				leaveButton.setBorderPainted(false);
				leaveButton.setRolloverEnabled(false);
				leaveButton.setSelectedIcon(new ImageIcon("images/arrow.png"));
				leaveButton.setIcon(new ImageIcon("images/arrow.png"));
				leaveButton.setMnemonic('n');
				items.add(leaveButton);
				leaveButton.setActionCommand("leave");
				leaveButton.addActionListener(listener);
				
				JPanel info = new JPanel();
				info.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
				info.setBackground(new Color(184, 134, 11));
				info.setBounds(84, 72, 125, 125);
				add(info);
				
						JLabel moneyLabel = new JLabel("Money: $" + wagon.getMoney());
						info.add(moneyLabel);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String s = ae.getActionCommand();
			if (s.equals("buy")) {
				// TODO mutate Wagon based on Shop
				try {
					Integer.valueOf(axleQuantity.getText());
					Integer.valueOf(wheelQuantity.getText());
					Integer.valueOf(tongueQuantity.getText());
					Integer.valueOf(oxenQuantity.getText());
					Integer.valueOf(clothesQuantity.getText());
					Integer.valueOf(bulletQuantity.getText());
					Integer.valueOf(foodQuantity.getText());
				} catch (java.lang.NumberFormatException e) {

				}
				shop.sellItem();
			} else if (s.equals("leave")) {
				// TODO Leave store and return to town
			}

		}

	}
}
