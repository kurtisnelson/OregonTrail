package com.kelsonprime.oregontrail.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.kelsonprime.oregontrail.controller.IconFactory;
import com.kelsonprime.oregontrail.controller.UserInputException;
import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Game;
import com.kelsonprime.oregontrail.model.ModelFactory;
import com.kelsonprime.oregontrail.model.Occupation;
import com.kelsonprime.oregontrail.model.Pace;
import com.kelsonprime.oregontrail.model.Player;
import com.kelsonprime.oregontrail.model.Ration;
import com.kelsonprime.oregontrail.model.Wagon;

public class NewGameScreen extends JPanel {
	private final static Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);
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
	private JComboBox paceBox, rationBox;

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
		playerName.setText("Kurt");
		playerName.setBounds(9, 29, 114, 19);
		body.add(playerName);
		playerName.setColumns(10);

		companionName = new JTextField();
		companionName.setBounds(9, 64, 114, 19);
		companionName.setText("Tan");
		body.add(companionName);
		companionName.setColumns(10);

		companion1Name = new JTextField();
		companion1Name.setBounds(9, 96, 114, 19);
		companion1Name.setText("Victoria");
		body.add(companion1Name);
		companion1Name.setColumns(10);

		companion2Name = new JTextField();
		companion2Name.setBounds(9, 127, 114, 19);
		companion2Name.setText("Matt");
		body.add(companion2Name);
		companion2Name.setColumns(10);

		companion3Name = new JTextField();
		companion3Name.setBounds(9, 158, 114, 19);
		companion3Name.setText("Aman");
		body.add(companion3Name);
		companion3Name.setColumns(10);

		JLabel occupationPickLabel = new JLabel("Pick an Occupation");
		occupationPickLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		occupationPickLabel.setForeground(Color.WHITE);
		occupationPickLabel.setBounds(242, 4, 176, 15);
		body.add(occupationPickLabel);

		ButtonListener listen = new ButtonListener();

		/*
		 * Set up the occupation area
		 */
		occupationGroup = new ButtonGroup();
		JPanel occPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) occPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setVgap(0);
		occPanel.setOpaque(false);
		occPanel.setSize(350, 20);
		occPanel.setLocation(175, 30);
		body.add(occPanel);

		for (Class<?> c : Occupation.getOccupations()) {
			String occName = "";
			// Do crazy reflection to dynamically build the GUI!
			try {
				Method m = c.getMethod("getStaticLabel");
				Object ans = m.invoke(null, (Object[]) null);
				occName = ans.toString();
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "Occupation reflexion failed.", e);
			}
			if (occName.length() > 0) {
				JRadioButton occButton = new JRadioButton(occName);
				occButton.setForeground(Color.WHITE);
				occButton.setBackground(Color.BLACK);
				occButton.setBounds(178, 27, 75, 23);
				occButton.setActionCommand(c.getCanonicalName());
				occButton.addActionListener(listen);
				occPanel.add(occButton);
				occupationGroup.add(occButton);
			}
		}

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

		paceBox = new JComboBox();
		paceBox.setBackground(Color.WHITE);
		paceBox.setModel(new DefaultComboBoxModel(Pace.values()));
		paceBox.setSelectedIndex(2);
		paceBox.setBounds(62, 226, 124, 24);
		body.add(paceBox);

		rationBox = new JComboBox();
		rationBox.setBackground(Color.WHITE);
		rationBox.setModel(new DefaultComboBoxModel(Ration.values()));
		rationBox.setSelectedIndex(2);
		rationBox.setBounds(228, 226, 124, 24);
		body.add(rationBox);

		JButton continueButton = new JButton();
		continueButton.setLocation(454, 189);
		continueButton.setSize(50, 22);
		continueButton.setBackground(Color.WHITE);
		continueButton.setOpaque(false);
		continueButton.setBorderPainted(false);
		continueButton.setRolloverEnabled(false);
		continueButton.setSelectedIcon(IconFactory.arrow());
		continueButton.setIcon(IconFactory.arrow());
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

		Occupation occupation;
		Player newPlayer;
		ArrayList<Companion> companionList;
		try {
			occupation = ModelFactory.buildOccupation(occupationGroup
					.getSelection().getActionCommand());
			newPlayer = ModelFactory.buildPlayer(playerName.getText(),
					occupation);
			companionList = ModelFactory.buildCompanions(
					companionName.getText(), companion2Name.getText());
		} catch (UserInputException e) {
			e.generateBox(app.getFrame());
			return;
		}

		Wagon newWagon = new Wagon(newPlayer, companionList);
		Game newGame = new Game(newWagon);
		newGame.setRation((Ration) rationBox.getSelectedItem());
		newGame.setPace((Pace) paceBox.getSelectedItem());
		app.loadGame(newGame);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String ac = ae.getActionCommand();
			if (ac.equals("continue")) {
				createGame();
				return;
			}
			/*
			 * Assume the occupation triggered Do crazy reflection to
			 * dynamically support new Occupations!
			 */
			Class<?> c;
			try {
				c = Class.forName(ac);
			} catch (ClassNotFoundException e) {
				LOGGER.log(Level.WARNING, "Uncaught action.", e);
				return;
			}
			try {
				Method m = c.getMethod("getStaticMoney");
				int money = (Integer) m.invoke(null, (Object[]) null);
				startingMoney.setText("$" + money);
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE,
						"Occupation getMoney reflection failed.", e);
			}
			try {
				Method m = c.getMethod("getStaticDescription");
				String ability = (String) m.invoke(null, (Object[]) null);
				abilityList.setText(ability);
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE,
						"Occupation getDescription reflection failed.", e);
			}
		}
	}
}
