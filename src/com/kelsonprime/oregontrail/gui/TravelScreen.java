package com.kelsonprime.oregontrail.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import com.kelsonprime.oregontrail.controller.Button;

public class TravelScreen extends JPanel {
	private static final long serialVersionUID = -2616586129314449978L;
	
	OregonTrail app;
	JLabel lblTravel;
	
	public TravelScreen(OregonTrail app){
		super();
		this.app = app;
		setSize(new Dimension(600, 300));
		
		lblTravel = new JLabel("TRAVEL!");
		
		Button travel = new Button(new ImageIcon("images/MoveAheadButton.png"));
		travel.setPreferredSize(new Dimension(100, 50));
		travel.setBorder(null);
		travel.setActionCommand("travel");
		
		Button change = new Button(new ImageIcon("images/UpdateButton.png"));
		change.setPreferredSize(new Dimension(100, 50));
		change.setActionCommand("change");
		
		Button rest = new Button(new ImageIcon("images/RestButton.png"));
		rest.setPreferredSize(new Dimension(100, 50));
		rest.setActionCommand("rest");
		
		ButtonListener listen = new ButtonListener();
		travel.addActionListener(listen);
		change.addActionListener(listen);
		rest.addActionListener(listen);
		
		add(lblTravel);
		add(travel);
		add(change);
		add(rest);
	}
	
	public void paintComponent(Graphics g){
		Image regBG = new ImageIcon("images/OregonTrailTravelingScreenRegular.jpg").getImage();
		Image wagonA = new ImageIcon("images/OregonTrailIcon.png").getImage();
		Image wagonB = new ImageIcon("images/OregonTrailIcon.png").getImage();
		g.drawImage(regBG, 0, 0, this);
		g.drawImage(wagonA, 400, 120, this);
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if (s == "travel"){
				lblTravel.setText("You are Traveling!");
			}
			else if (s == "change"){
				lblTravel.setText("You updated your Conditions!");
			}
			else if (s == "rest"){
				lblTravel.setText("You are Resting!");
			}
		}
		
	}
}
