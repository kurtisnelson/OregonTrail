package com.kelsonprime.oregontrail.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.IconFactory;
import com.kelsonprime.oregontrail.controller.Pace;
import com.kelsonprime.oregontrail.controller.Ration;

public class OptionsScreen extends JPanel {
	
	OregonTrail app;
	
	public OptionsScreen(OregonTrail app) {
		super();
		
		this.app = app;
		this.setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 300));
		
		JPanel header = new JPanel();
		header.setBackground(Color.white);
		add(header, BorderLayout.NORTH);

		JLabel headerLabel = new JLabel("What would you like to do?");
		header.add(headerLabel);
		
		JPanel body = new JPanel();
		body.setForeground(Color.WHITE);
		body.setBackground(Color.BLACK);
		add(body, BorderLayout.CENTER);
		body.setLayout(null);
		
		JLabel startingConditionLabel = new JLabel("Set Conditions");
		startingConditionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		startingConditionLabel.setForeground(Color.WHITE);
		startingConditionLabel.setBounds(109, 189, 192, 15);
		body.add(startingConditionLabel);

		JLabel paceLabel = new JLabel("Pace");
		paceLabel.setForeground(Color.WHITE);
		paceLabel.setBounds(100, 210, 70, 15);
		body.add(paceLabel);

		JComboBox paceBox = new JComboBox();
		paceBox.setBackground(Color.WHITE);
		paceBox.setModel(new DefaultComboBoxModel(Pace.values()));
		paceBox.setSelectedIndex(2);
		paceBox.setBounds(62, 226, 124, 24);
		body.add(paceBox);
		
		JLabel rationingLabel = new JLabel("Rations");
		rationingLabel.setForeground(Color.WHITE);
		rationingLabel.setBounds(269, 210, 70, 15);
		body.add(rationingLabel);
		
		JComboBox rationBox = new JComboBox();
		rationBox.setBackground(Color.WHITE);
		rationBox.setModel(new DefaultComboBoxModel(Ration.values()));
		rationBox.setSelectedIndex(2);
		rationBox.setBounds(228, 226, 124, 24);
		body.add(rationBox);
		
		JButton continueButton = new JButton();
		continueButton.setLocation(454, 189);
		continueButton.setSize(50, 22);
		continueButton.setBackground(Color.WHITE);
		continueButton.setSelectedIcon(IconFactory.arrow);
		continueButton.setIcon(new ImageIcon(NewGameScreen.class.getResource("/images/arrow.png")));
		continueButton.setOpaque(false);
		continueButton.setBorderPainted(false);
		continueButton.setRolloverEnabled(false);
		body.add(continueButton);
		
		
	}
}
