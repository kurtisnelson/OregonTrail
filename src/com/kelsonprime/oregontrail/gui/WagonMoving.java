package com.kelsonprime.oregontrail.gui;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Panel;

public class WagonMoving {
	OregonTrail app;
	JPanel screen1;
	JPanel screen2;
	private JTextField txtOregonTrail;
	private JLabel lblNewLabel;
	public WagonMoving(OregonTrail app){
		super();
		this.app = app;
		//this.wagon = app.getWagon();
		//setSize(new Dimension(600, 300));
		screen1 = new JPanel();
	
		screen1.setBorder(new LineBorder(Color.BLACK, 3));
		screen1.setSize(400, 300);
		screen1.setLayout(new BorderLayout(0, 0));
		
		txtOregonTrail = new JTextField();
		txtOregonTrail.setFont(new Font("Stencil", Font.PLAIN, 15));
		txtOregonTrail.setText("                                            Oregon Trail");
		screen1.add(txtOregonTrail, BorderLayout.SOUTH);
		txtOregonTrail.setColumns(10);
		
		Panel panel = new Panel();
		
		panel.setBackground(new Color(135, 206, 235));
		screen1.add(panel, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\Victoria\\workspace\\OregonTrail\\images\\CoveredWagon.jpg"));
		//lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		//lblNewLabel.add(label);
		
		panel.add(lblNewLabel);
		screen2 = new JPanel();
	}

}
