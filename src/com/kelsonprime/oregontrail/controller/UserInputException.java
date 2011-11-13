package com.kelsonprime.oregontrail.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Exception to raise when the user specified invalid input
 * @author Kurt
 *
 * @version $Revision: 1.0 $
 */
public class UserInputException extends Exception {
	private static final long serialVersionUID = -3133813262854243737L;
	/**
	 * Constructor for UserInputException.
	 * @param message String
	 */
	public UserInputException(String message){
		super(message);
	}
	
	/**
	 * Display this exception as a <code>JOptionPane</code>
	 * @param frame JFrame
	 */
	public void generateBox(JFrame frame){
		JOptionPane.showMessageDialog(frame, this.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
	}
}
