package com.kelsonprime.oregontrail.controller;

import javax.swing.ImageIcon;

/**
 * Stores an arrow icon
 * @author Aman
 *
 */
public final class IconFactory {
	private static ImageIcon arrow;
	public static final ImageIcon arrow(){
		if(arrow == null)
			arrow = new ImageIcon("images/arrow.png");
		return arrow;
	}
}
