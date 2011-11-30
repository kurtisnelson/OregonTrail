// $codepro.audit.disable numericLiterals
package com.kelsonprime.oregontrail.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kelsonprime.oregontrail.controller.IconFactory;
import com.kelsonprime.oregontrail.controller.Updatable;
import com.kelsonprime.oregontrail.model.Wagon;
import com.kelsonprime.oregontrail.model.Pace;
import com.kelsonprime.oregontrail.model.Ration;

import javax.swing.JTextField;

/**
 * a JFrame that allows the user to see game stats and change ration/pace
 * @author Matthew
 *
 * @version $Revision: 1.0 $
 */
public class OptionsScreen extends JFrame implements Updatable {
	private static final long serialVersionUID = 6544540456115310106L;
	private OregonTrail app;
	private JPanel header, body;
	private JLabel paceLabel, rationingLabel;
	private JComboBox paceBox, rationBox;
	private ButtonListener listen;
	JButton continueButton;
	private JTextField foodField;
	
	/**
	 * constructor pops up new frame
	 * @param app in which to change ration/pace
	 */
	public OptionsScreen(OregonTrail app) {
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 400);
		this.setVisible(true);
		
		centerFrame();
		
		this.app = app;
		this.app.getListener().registerUpdatable(this);
		this.setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(400, 200));
		
		header = new JPanel();
		header.setBackground(Color.white);
		getContentPane().add(header, BorderLayout.NORTH);

		JLabel headerLabel = new JLabel("Your current wagon state");
		header.add(headerLabel);
		
		body = new JPanel();
		body.setForeground(Color.WHITE);
		body.setBackground(Color.WHITE);
		getContentPane().add(body, BorderLayout.CENTER);
		body.setLayout(null);

		paceLabel = new JLabel("Pace");
		paceLabel.setForeground(Color.BLACK);
		paceLabel.setBounds(14, 99, 70, 15);
		body.add(paceLabel);

		paceBox = new JComboBox();
		paceLabel.setLabelFor(paceBox);
		paceBox.setBackground(Color.WHITE);
		paceBox.setModel(new DefaultComboBoxModel(Pace.values()));
		paceBox.setSelectedIndex(2);
		paceBox.setBounds(14, 115, 124, 24);
		body.add(paceBox);
		
		rationingLabel = new JLabel("Rations");
		rationingLabel.setForeground(Color.BLACK);
		rationingLabel.setBounds(150, 99, 70, 15);
		body.add(rationingLabel);
		
		rationBox = new JComboBox();
		rationingLabel.setLabelFor(rationBox);
		rationBox.setBackground(Color.WHITE);
		rationBox.setModel(new DefaultComboBoxModel(Ration.values()));
		rationBox.setSelectedIndex(2);
		rationBox.setBounds(150, 115, 124, 24);
		body.add(rationBox);
		
		listen = new ButtonListener();
		
		continueButton = new JButton();
		continueButton.setLocation(332, 115);
		continueButton.setSize(50, 22);
		continueButton.setBackground(Color.WHITE);
		continueButton.setSelectedIcon(IconFactory.arrow());
		continueButton.setIcon(IconFactory.arrow());
		continueButton.setOpaque(false);
		continueButton.setBorderPainted(false);
		continueButton.setRolloverEnabled(false);
		continueButton.addActionListener(listen);
		continueButton.setActionCommand("continue");
		body.add(continueButton);
		
		JLabel foodLbl = new JLabel("Food:");
		foodLbl.setBounds(14, 12, 40, 15);
		body.add(foodLbl);
		
		foodField = new JTextField();
		foodField.setEditable(false);
		foodField.setBounds(61, 10, 40, 19);
		body.add(foodField);
		foodField.setColumns(10);
		
		update();
	}
	
	/**
	 * Method update.
	 * @see com.kelsonprime.oregontrail.controller.Updatable#update()
	 */
	public void update(){
		Wagon wagon = app.getWagon();
		foodField.setText(Integer.toString(wagon.countFood()));
	}
	
	public void centerFrame(){
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// Determine the new location of the window
		int width = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width / 2) - width / 2;
		int y = (dim.height / 2) - h / 2;
		// Move the window
		this.setLocation(x, y);
	}
	
	/**
	 * Gets user selection from combo boxes and changes Ration/Pace, then closes the frame.
	 */
	private void saveAndClose() {
		app.getGame().setRation((Ration) rationBox.getSelectedItem());
		app.getGame().setPace((Pace) paceBox.getSelectedItem());
		this.dispose();
		app.getListener().dispatchUpdate();
	}
	
	/**
	 * An ActionListener for the contine button in the options screen.
	 * @author Matthew
	 *
	 * @version $Revision: 1.0 $
	 */
	private class ButtonListener implements ActionListener {

		/**
		 * Method actionPerformed.
		 * @param e ActionEvent
		 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("continue")){
				saveAndClose();
				
			}			
		}		
	}
}


