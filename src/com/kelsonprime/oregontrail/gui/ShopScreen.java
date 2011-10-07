package com.kelsonprime.oregontrail.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.kelsonprime.oregontrail.controller.Shop;

public class ShopScreen extends JPanel {
	private static final long serialVersionUID = -7550296665413775236L;
	Shop shop;
	private JTextField txtNumoxen;
	private JTextField txtNumAxles;
	private JTextField txtNumwheels;
	private JTextField txtNumtongues;
	private JTextField txtNumclothes;
	private JTextField txtNumbullets;
	private JTextField txtNumfood;

	public ShopScreen(Shop shop) {
		this.shop = shop;
		setSize(new Dimension(600, 300));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(UIManager
				.getColor("OptionPane.warningDialog.titlePane.foreground"));
		panel.setForeground(UIManager
				.getColor("OptionPane.warningDialog.titlePane.foreground"));
		add(panel, BorderLayout.NORTH);

		JLabel lblWelcomeToThe = new JLabel("Welcome to the " + shop.getName()
				+ " Shop");
		lblWelcomeToThe.setForeground(Color.WHITE);
		panel.add(lblWelcomeToThe);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager
				.getColor("OptionPane.warningDialog.titlePane.shadow"));
		panel_1.setForeground(UIManager
				.getColor("OptionPane.warningDialog.titlePane.shadow"));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		txtNumAxles = new JTextField();
		txtNumAxles.setText("0");
		txtNumAxles.setBounds(410, 43, 88, 19);
		panel_1.add(txtNumAxles);
		txtNumAxles.setColumns(10);

		txtNumoxen = new JTextField();
		txtNumoxen.setText("0");
		txtNumoxen.setBounds(410, 12, 88, 19);
		panel_1.add(txtNumoxen);
		txtNumoxen.setColumns(10);

		txtNumwheels = new JTextField();
		txtNumwheels.setText("0");
		txtNumwheels.setBounds(410, 74, 88, 19);
		panel_1.add(txtNumwheels);
		txtNumwheels.setColumns(10);

		txtNumtongues = new JTextField();
		txtNumtongues.setText("0");
		txtNumtongues.setBounds(410, 105, 88, 19);
		panel_1.add(txtNumtongues);
		txtNumtongues.setColumns(10);

		txtNumclothes = new JTextField();
		txtNumclothes.setText("0");
		txtNumclothes.setBounds(410, 136, 88, 19);
		panel_1.add(txtNumclothes);
		txtNumclothes.setColumns(10);

		txtNumbullets = new JTextField();
		txtNumbullets.setText("0");
		txtNumbullets.setBounds(410, 168, 88, 19);
		panel_1.add(txtNumbullets);
		txtNumbullets.setColumns(10);

		txtNumfood = new JTextField();
		txtNumfood.setText("0");
		txtNumfood.setBounds(410, 201, 88, 19);
		panel_1.add(txtNumfood);
		txtNumfood.setColumns(10);

		JLabel lblOxen = new JLabel("Oxen");
		lblOxen.setBounds(375, 16, 41, 15);
		panel_1.add(lblOxen);

		JLabel lblAxle = new JLabel("Axle");
		lblAxle.setBounds(382, 45, 34, 15);
		panel_1.add(lblAxle);

		JLabel lblWheels = new JLabel("Wheels");
		lblWheels.setBounds(358, 75, 53, 17);
		panel_1.add(lblWheels);

		JLabel lblTongues = new JLabel("Tongues");
		lblTongues.setBounds(349, 107, 61, 15);
		panel_1.add(lblTongues);

		JLabel lblClothes = new JLabel("Clothes");
		lblClothes.setBounds(355, 138, 61, 15);
		panel_1.add(lblClothes);

		JLabel lblBullets = new JLabel("Bullets (10/box)");
		lblBullets.setBounds(302, 170, 108, 15);
		panel_1.add(lblBullets);

		JLabel lblFood = new JLabel("Food (lbs)");
		lblFood.setBounds(340, 203, 70, 15);
		panel_1.add(lblFood);

		JLabel lblAxleprice = new JLabel("$"
				+ Integer.toString(shop.getAxlePrice()));
		lblAxleprice.setBounds(506, 45, 61, 15);
		panel_1.add(lblAxleprice);

		JLabel lblWheelprice = new JLabel("$"
				+ Integer.toString(shop.getWheelPrice()));
		lblWheelprice.setBounds(505, 76, 61, 15);
		panel_1.add(lblWheelprice);

		JLabel lblOxenprice = new JLabel("$"
				+ Integer.toString(shop.getOxenPrice()));
		lblOxenprice.setBounds(506, 14, 70, 15);
		panel_1.add(lblOxenprice);

		JLabel lblTongueprice = new JLabel("$"
				+ Integer.toString(shop.getTonguePrice()));
		lblTongueprice.setBounds(506, 107, 70, 15);
		panel_1.add(lblTongueprice);

		JLabel lblClothesprice = new JLabel("$"
				+ Integer.toString(shop.getClothesPrice()));
		lblClothesprice.setBounds(506, 138, 70, 15);
		panel_1.add(lblClothesprice);

		JLabel lblBulletprice = new JLabel("$"
				+ Integer.toString(shop.getBulletPrice()));
		lblBulletprice.setBounds(506, 170, 70, 15);
		panel_1.add(lblBulletprice);

		JLabel lblFoodprice = new JLabel("$"
				+ Integer.toString(shop.getFoodPrice()));
		lblFoodprice.setBounds(506, 203, 70, 15);
		panel_1.add(lblFoodprice);

		JButton btnBuyItems = new JButton("Buy Items");
		btnBuyItems.setBounds(320, 232, 117, 25);
		panel_1.add(btnBuyItems);

		JButton btnLeaveShop = new JButton("Leave Shop");
		btnLeaveShop.setBounds(450, 232, 117, 25);
		panel_1.add(btnLeaveShop);

		JLabel lblMoney = new JLabel("Money: $");
		lblMoney.setBounds(12, 14, 70, 15);
		panel_1.add(lblMoney);
	}
}
