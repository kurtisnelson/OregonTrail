package com.kelsonprime.oregontrail.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.IconFactory;
import com.kelsonprime.oregontrail.controller.Threader;
import com.kelsonprime.oregontrail.controller.UserInputException;
import com.kelsonprime.oregontrail.model.Shop;
import com.kelsonprime.oregontrail.model.Wagon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;

public class ShopScreen extends LocationScreen implements KeyListener {
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
	private int moneySpent;
	private JLabel moneyLabel, totalPurchase, totalLeft;

	public ShopScreen(OregonTrail app, Shop shop) {
		super(app);
		this.shop = shop;
		this.wagon = app.getWagon();
		setSize(new Dimension(600, 300));

		ButtonListener listener = new ButtonListener();
		setLayout(null);
		addKeyListener(this);
		setFocusable(true);

		JPanel header = new JPanel();
		header.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK,
				Color.BLACK, null, null));
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
		items.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		items.setBackground(new Color(184, 134, 11));
		items.setBounds(268, 40, 304, 248);
		add(items);
		items.setLayout(new GridLayout(0, 3, 5, 5));

		JLabel oxenLabel = new JLabel("Oxen");
		items.add(oxenLabel);

		oxenQuantity = new JTextField();
		oxenQuantity.addKeyListener(this);
		oxenQuantity.setFocusable(true);
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
		axleQuantity.addKeyListener(this);
		axleQuantity.setFocusable(true);
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
		wheelQuantity.addKeyListener(this);
		wheelQuantity.setFocusable(true);
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
		tongueQuantity.addKeyListener(this);
		tongueQuantity.setFocusable(true);
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
		clothesQuantity.addKeyListener(this);
		clothesQuantity.setFocusable(true);
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
		bulletQuantity.addKeyListener(this);
		bulletQuantity.setFocusable(true);
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
		foodQuantity.addKeyListener(this);
		foodQuantity.setFocusable(true);
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
		leaveButton.setSize(50, 22);
		leaveButton.setBackground(Color.WHITE);
		leaveButton.setOpaque(false);
		leaveButton.setBorderPainted(false);
		leaveButton.setRolloverEnabled(false);
		leaveButton.setSelectedIcon(IconFactory.arrow);
		leaveButton.setIcon(IconFactory.arrow);
		leaveButton.setMnemonic('n');
		items.add(leaveButton);
		leaveButton.setActionCommand("leave");
		leaveButton.addActionListener(listener);

		moneySpent = shop.axlePrice() * Integer.valueOf(axleQuantity.getText())
				+ shop.wheelPrice() * Integer.valueOf(wheelQuantity.getText())
				+ shop.tonguePrice()
				* Integer.valueOf(tongueQuantity.getText()) + shop.oxenPrice()
				* Integer.valueOf(oxenQuantity.getText()) + shop.clothesPrice()
				* Integer.valueOf(clothesQuantity.getText())
				+ shop.bulletPrice()
				* Integer.valueOf(bulletQuantity.getText()) + shop.foodPrice()
				* Integer.valueOf(foodQuantity.getText());

		JPanel info = new JPanel();
		info.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		info.setBackground(new Color(184, 134, 11));
		info.setBounds(25, 72, 175, 125);
		add(info);

		moneyLabel = new JLabel("Total Money: $" + wagon.getMoney());
		info.add(moneyLabel);

		totalPurchase = new JLabel("Total Purchase: $"
				+ Integer.toString(moneySpent));
		info.add(totalPurchase);

		totalLeft = new JLabel("Money Left: $"
				+ Integer.toString(wagon.getMoney() - moneySpent));
		info.add(totalLeft);

	}
	
	public void sellItems(){
		int axles;
		int wheels;
		int tongues;
		int oxen;
		int clothes;
		int bullets;
		int food;
		boolean sellAllowed = true;
		try {
			axles = Integer.valueOf(axleQuantity.getText());
			wheels = Integer.valueOf(wheelQuantity.getText());
			tongues = Integer.valueOf(tongueQuantity.getText());
			oxen = Integer.valueOf(oxenQuantity.getText());
			clothes = Integer.valueOf(clothesQuantity.getText());
			bullets = Integer.valueOf(bulletQuantity.getText());
			food = Integer.valueOf(foodQuantity.getText());
		} catch (java.lang.NumberFormatException e) {
			sellAllowed = false;
			JOptionPane.showMessageDialog(app.getFrame(), "Non-Numerical Input has been found!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// TODO actually sell stuff
		if (sellAllowed){
			try{
				shop.sellToWagon(wagon, axles, wheels, tongues);
				shop.sellToWagon(wagon, Wagon.OXEN, oxen);
				shop.sellToWagon(wagon, Wagon.CLOTHES, clothes);
				shop.sellToWagon(wagon, Wagon.BULLETS, bullets);
				shop.sellToWagon(wagon, Wagon.FOOD, food);
			}catch(UserInputException e){
				e.generateBox(app.getFrame());
			}
			
			axleQuantity.setText("0");
			wheelQuantity.setText("0");
			tongueQuantity.setText("0");
			oxenQuantity.setText("0");
			clothesQuantity.setText("0");
			bulletQuantity.setText("0");
			foodQuantity.setText("0");
			update();
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {

	}

	@Override
	public void keyReleased(KeyEvent ke) {
		update();
	}

	public void update() {
		Threader.executeNow(new Runnable() {
			public void run(){
		try {
			moneySpent = shop.axlePrice()
					* Integer.valueOf(axleQuantity.getText())
					+ shop.wheelPrice()
					* Integer.valueOf(wheelQuantity.getText())
					+ shop.tonguePrice()
					* Integer.valueOf(tongueQuantity.getText())
					+ shop.oxenPrice()
					* Integer.valueOf(oxenQuantity.getText())
					+ shop.clothesPrice()
					* Integer.valueOf(clothesQuantity.getText())
					+ shop.bulletPrice()
					* Integer.valueOf(bulletQuantity.getText())
					+ shop.foodPrice()
					* Integer.valueOf(foodQuantity.getText());
			moneyLabel.setText("Total Money: $"+Integer.toString(wagon.getMoney()));
			totalPurchase.setText("Total Purchase: $"+moneySpent);
			totalLeft.setText("Money Left: $" + (wagon.getMoney() - moneySpent));
		} catch (java.lang.NumberFormatException e) {
			//Let's just ignore their input and throw an error if they try to go through
		}
		repaint();
		}});

	}

	@Override
	public void keyTyped(KeyEvent ke) {

	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String s = ae.getActionCommand();
			if (s.equals("buy")) {
				sellItems();
			} else if (s.equals("leave")) {
				// TODO Leave store and return to town
			}

		}

	}
}
