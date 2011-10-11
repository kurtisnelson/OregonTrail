package com.kelsonprime.oregontrail.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserInputException extends Exception {
	private static final long serialVersionUID = -3133813262854243737L;
	public UserInputException(String message){
		super(message);
	}
	
	public void generateBox(JFrame frame){
		JOptionPane.showMessageDialog(frame, this.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
	}
}
