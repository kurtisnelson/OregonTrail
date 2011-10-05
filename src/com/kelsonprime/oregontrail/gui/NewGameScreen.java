package com.kelsonprime.oregontrail.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;


public class NewGameScreen extends JFrame {
	private JTextField txtPlayer;
	private JTextField txtCompanion;
	private JTextField txtCompanion_1;
	private JTextField txtCompanion_2;
	private JTextField txtCompanion_3;
	private JTextField txtNumwheels;
	private JTextField txtNumaxles;
	private JTextField txtNumtongues;
	private JTextField txtNumclothes;
	private JTextField txtNumbullets;
	private JTextField txtNumoxen;
	private JTextField txtNumfood;
	
	public NewGameScreen(String title) {
		super(title);
		setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("OptionPane.warningDialog.titlePane.shadow"));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblGetReadyFor = new JLabel("Get Ready for the Oregon Trail!");
		panel.add(lblGetReadyFor);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(UIManager.getColor("OptionPane.warningDialog.titlePane.foreground"));
		getContentPane().add(panel_2, BorderLayout.CENTER);
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
		lblPickAnOccupation.setForeground(Color.WHITE);
		lblPickAnOccupation.setBounds(152, 2, 134, 15);
		panel_2.add(lblPickAnOccupation);
		
		JRadioButton rdbtnBanker = new JRadioButton("Banker");
		rdbtnBanker.setBounds(178, 27, 75, 23);
		panel_2.add(rdbtnBanker);
		
		JRadioButton rdbtnCarpenter = new JRadioButton("Carpenter");
		rdbtnCarpenter.setBounds(178, 62, 97, 23);
		panel_2.add(rdbtnCarpenter);
		
		JRadioButton rdbtnFarmer = new JRadioButton("Farmer");
		rdbtnFarmer.setBounds(178, 94, 75, 23);
		panel_2.add(rdbtnFarmer);
		
		JLabel lblPartyNames = new JLabel("Party Names");
		lblPartyNames.setForeground(Color.WHITE);
		lblPartyNames.setBounds(9, 2, 97, 15);
		panel_2.add(lblPartyNames);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setForeground(Color.WHITE);
		lblMoney.setBounds(161, 145, 70, 15);
		panel_2.add(lblMoney);
		
		JLabel lblStockTheWagon = new JLabel("Stock The Wagon ");
		lblStockTheWagon.setForeground(Color.WHITE);
		lblStockTheWagon.setBounds(306, 2, 132, 15);
		panel_2.add(lblStockTheWagon);
		
		txtNumwheels = new JTextField();
		txtNumwheels.setText("numWheels");
		txtNumwheels.setBounds(316, 29, 114, 19);
		panel_2.add(txtNumwheels);
		txtNumwheels.setColumns(10);
		
		txtNumaxles = new JTextField();
		txtNumaxles.setText("numAxles");
		txtNumaxles.setBounds(316, 45, 114, 19);
		panel_2.add(txtNumaxles);
		txtNumaxles.setColumns(10);
		
		txtNumtongues = new JTextField();
		txtNumtongues.setText("numTongues");
		txtNumtongues.setBounds(316, 64, 114, 19);
		panel_2.add(txtNumtongues);
		txtNumtongues.setColumns(10);
		
		txtNumclothes = new JTextField();
		txtNumclothes.setText("numClothes");
		txtNumclothes.setBounds(316, 81, 114, 19);
		panel_2.add(txtNumclothes);
		txtNumclothes.setColumns(10);
		
		txtNumbullets = new JTextField();
		txtNumbullets.setText("numBullets");
		txtNumbullets.setBounds(316, 96, 114, 19);
		panel_2.add(txtNumbullets);
		txtNumbullets.setColumns(10);
		
		txtNumoxen = new JTextField();
		txtNumoxen.setText("numOxen");
		txtNumoxen.setBounds(316, 114, 114, 19);
		panel_2.add(txtNumoxen);
		txtNumoxen.setColumns(10);
		
		txtNumfood = new JTextField();
		txtNumfood.setText("numFood");
		txtNumfood.setBounds(316, 127, 114, 19);
		panel_2.add(txtNumfood);
		txtNumfood.setColumns(10);
	}
	
	/**
	 * Here's some pseudo code representing the work that needs to be done with the info above.
	 * We can uncoment it once we're sure everything above is correct. I just wanted to start thinking it through.
	 * 
	 * ArrayList companionList = new ArrayList(4);
	 * if(companion 1 has text)
	 * 	companionList.add(new Companion(text));
	 * etc. for all companions.
	 * 
	 * Wagon newWagon = new Wagon(new Player(player text, occupation), companionList)
	 * Game newGame = newGame(new Listener(), newWagon);
	 * 
	 * 
	 *  
	 */
}
