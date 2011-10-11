package com.kelsonprime.oregontrail.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.model.Banker;
import com.kelsonprime.oregontrail.model.Carpenter;
import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Farmer;
import com.kelsonprime.oregontrail.model.Occupation;
import com.kelsonprime.oregontrail.model.Player;
import com.kelsonprime.oregontrail.model.Wagon;

public class NewGameScreen extends JPanel {
	private static final long serialVersionUID = 7996950179577943594L;
	OregonTrail app;
	private JTextField playerName;
	private JTextField companionName;
	private JTextField companion1Name;
	private JTextField companion2Name;
	private JTextField companion3Name;
	private ButtonGroup occupationGroup;
	private JLabel abilityList;
	private JLabel startingMoney;

	public NewGameScreen(OregonTrail app) {
		super();
		this.app = app;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 300));

		JPanel header = new JPanel();
		header.setBackground(Color.white);
		add(header, BorderLayout.NORTH);

		JLabel headerLabel = new JLabel("Get Ready for the Oregon Trail!");
		header.add(headerLabel);

		JPanel body = new JPanel();
		body.setForeground(Color.WHITE);
		body.setBackground(Color.BLACK);
		add(body, BorderLayout.CENTER);
		body.setLayout(null);

		playerName = new JTextField();
		playerName.setBounds(9, 29, 114, 19);
		playerName.setText("Player 1");
		body.add(playerName);
		playerName.setColumns(10);

		companionName = new JTextField();
		companionName.setBounds(9, 64, 114, 19);
		companionName.setText("Companion 1");
		body.add(companionName);
		companionName.setColumns(10);

		companion1Name = new JTextField();
		companion1Name.setBounds(9, 96, 114, 19);
		companion1Name.setText("Companion 2");
		body.add(companion1Name);
		companion1Name.setColumns(10);

		companion2Name = new JTextField();
		companion2Name.setBounds(9, 127, 114, 19);
		companion2Name.setText("Companion 3");
		body.add(companion2Name);
		companion2Name.setColumns(10);

		companion3Name = new JTextField();
		companion3Name.setBounds(9, 158, 114, 19);
		companion3Name.setText("Companion 4");
		body.add(companion3Name);
		companion3Name.setColumns(10);

		JLabel occupationPickLabel = new JLabel("Pick an Occupation");
		occupationPickLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		occupationPickLabel.setForeground(Color.WHITE);
		occupationPickLabel.setBounds(242, 4, 176, 15);
		body.add(occupationPickLabel);

		ButtonListener listen = new ButtonListener();

		JRadioButton bankerButton = new JRadioButton("Banker");
		bankerButton.setBounds(178, 27, 75, 23);
		bankerButton.setActionCommand("banker");
		bankerButton.addActionListener(listen);
		body.add(bankerButton);

		JRadioButton carpenterButton = new JRadioButton("Carpenter");
		carpenterButton.setBounds(269, 27, 97, 23);
		carpenterButton.setActionCommand("carpenter");
		carpenterButton.addActionListener(listen);
		body.add(carpenterButton);

		JRadioButton farmerButton = new JRadioButton("Farmer");
		farmerButton.setBounds(385, 27, 75, 23);
		farmerButton.setActionCommand("farmer");
		farmerButton.addActionListener(listen);
		body.add(farmerButton);

		occupationGroup = new ButtonGroup();
		occupationGroup.add(bankerButton);
		occupationGroup.add(carpenterButton);
		occupationGroup.add(farmerButton);

		JLabel nameLabel = new JLabel("Party Names");
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(9, 2, 114, 15);
		body.add(nameLabel);

		JLabel moneyLabel = new JLabel("Starting Money:");
		moneyLabel.setForeground(Color.WHITE);
		moneyLabel.setBounds(184, 112, 117, 15);
		body.add(moneyLabel);

		JLabel abilityLabel = new JLabel("Occupational Abilities:");
		abilityLabel.setForeground(Color.WHITE);
		abilityLabel.setBounds(183, 66, 262, 15);
		body.add(abilityLabel);

		JLabel startingConditionLabel = new JLabel("Set Starting Conditions");
		startingConditionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		startingConditionLabel.setForeground(Color.WHITE);
		startingConditionLabel.setBounds(109, 189, 192, 15);
		body.add(startingConditionLabel);

		JLabel paceLabel = new JLabel("Pace");
		paceLabel.setForeground(Color.WHITE);
		paceLabel.setBounds(100, 210, 70, 15);
		body.add(paceLabel);

		JLabel rationingLabel = new JLabel("Rations");
		rationingLabel.setForeground(Color.WHITE);
		rationingLabel.setBounds(269, 210, 70, 15);
		body.add(rationingLabel);

		JComboBox paceBox = new JComboBox();
		paceBox.setBounds(62, 226, 124, 24);
		body.add(paceBox);
		paceBox.addItem("Light");
		paceBox.addItem("Moderate");
		paceBox.addItem("Heavy");
		paceBox.addItem("Grueling");

		JComboBox rationBox = new JComboBox();
		rationBox.setBounds(228, 226, 124, 24);
		body.add(rationBox);
		rationBox.addItem("Bare Bones");
		rationBox.addItem("Meager");
		rationBox.addItem("Adequate");
		rationBox.addItem("Filling");

		JButton continueButton = new JButton("Continue");
		continueButton.setBounds(430, 226, 144, 25);
		continueButton.setActionCommand("continue");
		continueButton.addActionListener(listen);
		body.add(continueButton);

		abilityList = new JLabel("---");
		abilityList.setFont(new Font("Dialog", Font.PLAIN, 12));
		abilityList.setForeground(Color.WHITE);
		abilityList.setBounds(193, 85, 282, 15);
		body.add(abilityList);

		startingMoney = new JLabel("---");
		startingMoney.setFont(new Font("Dialog", Font.PLAIN, 12));
		startingMoney.setForeground(Color.WHITE);
		startingMoney.setBounds(194, 129, 145, 15);
		body.add(startingMoney);
	}

	public void createGame() {

		ArrayList<Companion> companionList = new ArrayList<Companion>(4);
		if (companionName.getText() != null) {
			companionList.add(new Companion(companionName.getText()));
		}
		if (companion1Name.getText() != null) {
			companionList.add(new Companion(companion1Name.getText()));
		}
		if (companion2Name.getText() != null) {
			companionList.add(new Companion(companion2Name.getText()));
		}
		if (companion3Name.getText() != null) {
			companionList.add(new Companion(companion3Name.getText()));
		}

		String occString = occupationGroup.getSelection().getActionCommand();
		Occupation newOccupation;

		if (occString.equals("banker")) {
			newOccupation = new Banker();
		} else if (occString.equals("carpenter")) {
			newOccupation = new Carpenter();
		} else {
			newOccupation = new Farmer();
		}

		Player newPlayer = new Player(playerName.getText(), newOccupation);

		Wagon newWagon = new Wagon(newPlayer, companionList);

		Game newGame = new Game(new Listener(), newWagon);

		app.setGame(newGame);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getActionCommand();
			if (o.equals("banker")) {
				abilityList.setText("-None-");
				startingMoney.setText("$3000");
			} else if (o.equals("carpenter")) {
				abilityList.setText("Wagon Fixing");
				startingMoney.setText("$2000");
			} else if (o.equals("farmer")) {
				abilityList.setText("Oxen Care | Food Scavaging");
				startingMoney.setText("$1500");
			} else if (o.equals("continue")) {
				createGame();
			}
		}
	}
}
