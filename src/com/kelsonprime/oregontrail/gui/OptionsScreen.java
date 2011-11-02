package com.kelsonprime.oregontrail.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private static final long serialVersionUID = 6544540456115310106L;
	OregonTrail app;
	JPanel header, body;
	JLabel headerLabel, startingConditionLabel, paceLabel, rationingLabel;
	JComboBox paceBox, rationBox;
	ButtonListener listen;
	JButton continueButton;
	
	public OptionsScreen(OregonTrail app) {
		super();
		
		this.app = app;
		this.setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(600, 300));
		
		header = new JPanel();
		header.setBackground(Color.white);
		add(header, BorderLayout.NORTH);

		JLabel headerLabel = new JLabel("What would you like to do?");
		header.add(headerLabel);
		
		body = new JPanel();
		body.setForeground(Color.WHITE);
		body.setBackground(Color.WHITE);
		add(body, BorderLayout.CENTER);
		body.setLayout(null);
		
		startingConditionLabel = new JLabel("Set Conditions");
		startingConditionLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		startingConditionLabel.setForeground(Color.BLACK);
		startingConditionLabel.setBounds(109, 189, 192, 15);
		body.add(startingConditionLabel);

		paceLabel = new JLabel("Pace");
		paceLabel.setForeground(Color.BLACK);
		paceLabel.setBounds(100, 210, 70, 15);
		body.add(paceLabel);

		paceBox = new JComboBox();
		paceBox.setBackground(Color.WHITE);
		paceBox.setModel(new DefaultComboBoxModel(Pace.values()));
		paceBox.setSelectedIndex(2);
		paceBox.setBounds(62, 226, 124, 24);
		body.add(paceBox);
		
		rationingLabel = new JLabel("Rations");
		rationingLabel.setForeground(Color.BLACK);
		rationingLabel.setBounds(269, 210, 70, 15);
		body.add(rationingLabel);
		
		rationBox = new JComboBox();
		rationBox.setBackground(Color.WHITE);
		rationBox.setModel(new DefaultComboBoxModel(Ration.values()));
		rationBox.setSelectedIndex(2);
		rationBox.setBounds(228, 226, 124, 24);
		body.add(rationBox);
		
		listen = new ButtonListener();
		
		continueButton = new JButton();
		continueButton.setLocation(454, 189);
		continueButton.setSize(50, 22);
		continueButton.setBackground(Color.WHITE);
		continueButton.setSelectedIcon(IconFactory.arrow);
		continueButton.setIcon(new ImageIcon(NewGameScreen.class.getResource("/images/arrow.png")));
		continueButton.setOpaque(false);
		continueButton.setBorderPainted(false);
		continueButton.setRolloverEnabled(false);
		continueButton.addActionListener(listen);
		continueButton.setActionCommand("continue");
		body.add(continueButton);
		
		
	}
	
	private void updateApp() {
		app.getGame().setRation((Ration) rationBox.getSelectedItem());
		app.getGame().setPace((Pace) paceBox.getSelectedItem());
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("continue")){
				updateApp();
			}			
		}		
	}
}

