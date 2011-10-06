package com.kelsonprime.oregontrail.gui;

import com.kelsonprime.oregontrail.logic.Companion;
import com.kelsonprime.oregontrail.logic.Game;
import com.kelsonprime.oregontrail.logic.Occupation;
import com.kelsonprime.oregontrail.logic.Player;
import com.kelsonprime.oregontrail.logic.Wagon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JComboBox;

public class NewGameScreen extends JPanel {
	OregonTrail app;
	private JTextField txtPlayer;
	private JTextField txtCompanion;
	private JTextField txtCompanion_1;
	private JTextField txtCompanion_2;
	private JTextField txtCompanion_3;
	private ButtonGroup occupationGroup;

	public NewGameScreen(OregonTrail app) {
		super();
		this.app = app;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600,300));
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("OptionPane.warningDialog.titlePane.shadow"));
		add(panel, BorderLayout.NORTH);
		
		JLabel lblGetReadyFor = new JLabel("Get Ready for the Oregon Trail!");
		panel.add(lblGetReadyFor);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(UIManager.getColor("OptionPane.warningDialog.titlePane.foreground"));
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(9, 29, 114, 19);
		txtPlayer.setText("Player 1");
		panel_2.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		txtCompanion = new JTextField();
		txtCompanion.setBounds(9, 64, 114, 19);
		txtCompanion.setText("Companion 1");
		panel_2.add(txtCompanion);
		txtCompanion.setColumns(10);
		
		txtCompanion_1 = new JTextField();
		txtCompanion_1.setBounds(9, 96, 114, 19);
		txtCompanion_1.setText("Companion 2");
		panel_2.add(txtCompanion_1);
		txtCompanion_1.setColumns(10);
		
		txtCompanion_2 = new JTextField();
		txtCompanion_2.setBounds(9, 127, 114, 19);
		txtCompanion_2.setText("Companion 3");
		panel_2.add(txtCompanion_2);
		txtCompanion_2.setColumns(10);
		
		txtCompanion_3 = new JTextField();
		txtCompanion_3.setBounds(9, 158, 114, 19);
		txtCompanion_3.setText("Companion 4");
		panel_2.add(txtCompanion_3);
		txtCompanion_3.setColumns(10);
		
		JLabel lblPickAnOccupation = new JLabel("Pick an Occupation");
		lblPickAnOccupation.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPickAnOccupation.setForeground(Color.WHITE);
		lblPickAnOccupation.setBounds(242, 4, 176, 15);
		panel_2.add(lblPickAnOccupation);
		
		JRadioButton rdbtnBanker = new JRadioButton("Banker");
		rdbtnBanker.setBounds(178, 27, 75, 23);
		rdbtnBanker.setActionCommand("banker");
		panel_2.add(rdbtnBanker);
		
		JRadioButton rdbtnCarpenter = new JRadioButton("Carpenter");
		rdbtnCarpenter.setBounds(274, 27, 97, 23);
		rdbtnBanker.setActionCommand("carpenter");
		panel_2.add(rdbtnCarpenter);
		
		JRadioButton rdbtnFarmer = new JRadioButton("Farmer");
		rdbtnFarmer.setBounds(385, 27, 75, 23);
		rdbtnBanker.setActionCommand("carpenter");
		panel_2.add(rdbtnFarmer);
		
		occupationGroup = new ButtonGroup();
		occupationGroup.add(rdbtnBanker);
		occupationGroup.add(rdbtnCarpenter);
		occupationGroup.add(rdbtnFarmer);
		
		JLabel lblPartyNames = new JLabel("Party Names");
		lblPartyNames.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPartyNames.setForeground(Color.WHITE);
		lblPartyNames.setBounds(9, 2, 114, 15);
		panel_2.add(lblPartyNames);
		
		JLabel lblMoney = new JLabel("Starting Money:");
		lblMoney.setForeground(Color.WHITE);
		lblMoney.setBounds(184, 112, 117, 15);
		panel_2.add(lblMoney);
		
		JLabel lblOccupationalAbilities = new JLabel("Occupational Abilities:");
		lblOccupationalAbilities.setForeground(Color.WHITE);
		lblOccupationalAbilities.setBounds(183, 66, 169, 15);
		panel_2.add(lblOccupationalAbilities);
		
		JLabel lblSetStartingConditions = new JLabel("Set Starting Conditions");
		lblSetStartingConditions.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSetStartingConditions.setForeground(Color.WHITE);
		lblSetStartingConditions.setBounds(109, 189, 192, 15);
		panel_2.add(lblSetStartingConditions);
		
		JLabel lblPace = new JLabel("Pace");
		lblPace.setForeground(Color.WHITE);
		lblPace.setBounds(100, 210, 70, 15);
		panel_2.add(lblPace);
		
		JLabel lblRationing = new JLabel("Rations");
		lblRationing.setForeground(Color.WHITE);
		lblRationing.setBounds(269, 210, 70, 15);
		panel_2.add(lblRationing);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(62, 226, 124, 24);
		panel_2.add(comboBox);
		comboBox.addItem("Light");
		comboBox.addItem("Moderate");
		comboBox.addItem("Heavy");
		comboBox.addItem("Grueling");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(228, 226, 124, 24);
		panel_2.add(comboBox_1);
		comboBox_1.addItem("Bare Bones");
		comboBox_1.addItem("Meager");
		comboBox_1.addItem("Adequate");
		comboBox_1.addItem("Filling");
		
		JButton btnContinue = new JButton("Continue -->");
		btnContinue.setBounds(430, 226, 144, 25);
		panel_2.add(btnContinue);
	}
	
	public void createGame(){
		
		ArrayList<Companion> companionList = new ArrayList<Companion>(4);
		if (txtCompanion.getText() != null){
			companionList.add(new Companion(txtCompanion.getText()));
		}
		if (txtCompanion_1.getText() != null){
			companionList.add(new Companion(txtCompanion_1.getText()));
		}
		if (txtCompanion_2.getText() != null){
			companionList.add(new Companion(txtCompanion_2.getText()));
		}
		if (txtCompanion_3.getText() != null){
			companionList.add(new Companion(txtCompanion_3.getText()));
		}
		
		String occString = occupationGroup.getSelection().getActionCommand();
		Occupation newOccupation;
		
		if (occString.equals("Banker")){
			newOccupation = null;
			// TODO once the occupation classes get made, this should create and instance of Banker.
		}
		else if (occString.equals("carpenter")){
			newOccupation = null;
			// TODO once the occupation classes get made, this should create and instance of Carpenter.
		}
		else {
			newOccupation = null;
			// TODO once the occupation classes get made, this should create and instance of Farmer.
		}
		
		Player newPlayer = new Player(txtPlayer.getText(), newOccupation);
		
		Wagon newWagon = new Wagon(newPlayer, companionList);
		
		Game newGame = new Game(new Listener(), newWagon);
		
		app.setGame(newGame);
	}
}
