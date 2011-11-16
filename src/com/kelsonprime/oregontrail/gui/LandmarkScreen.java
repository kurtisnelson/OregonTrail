package com.kelsonprime.oregontrail.gui;

import com.kelsonprime.oregontrail.model.Landmark;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI for a <code>Landmark</code>
 * @see com.kelsonprime.oregontrail.model.Landmark
 */
public class LandmarkScreen extends LocationScreen {
	private static final long serialVersionUID = 6338930312894045281L;
	
	private Landmark landmark;
	/**
	 * Create GUI for landmark
	 * @param app OregonTrail
	 * @param landmark Landmark
	 */
	public LandmarkScreen(OregonTrail app, Landmark landmark) {
		super(app);
		this.landmark = landmark;
		draw();
		setLayout(new FlowLayout());
		
		ButtonListener listener = new ButtonListener();
		JButton cont = new JButton("Continue");
		cont.setActionCommand("Continue");
		cont.addActionListener(listener);
		add(cont);
	}
	
	public void draw(){
		JLabel lblNewLabel = new JLabel("You've arrived:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(154, 119, 141, 15);
		add(lblNewLabel);
		
		JLabel lblName = new JLabel(landmark.toString());
		lblName.setForeground(Color.RED);
		lblName.setBounds(175, 146, 70, 15);
		add(lblName);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String s = ae.getActionCommand();
			
			if (s.equalsIgnoreCase("continue"))
				getApp().leaveLocation();
			
		}
		
	}
}
