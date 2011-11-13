package com.kelsonprime.oregontrail.gui;

import com.kelsonprime.oregontrail.model.Landmark;
import javax.swing.JLabel;
import java.awt.Color;

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
}
