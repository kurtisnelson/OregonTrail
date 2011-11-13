package com.kelsonprime.oregontrail.controller;

import javax.swing.ImageIcon;

/**
 * Stores ImageIcons
 * @author Kurt Nelson
 *
 * @version $Revision: 1.0 $
 */
public final class IconFactory {
	private static ImageIcon arrow;
	/**
	 * Arrow icon
	 * @return ImageIcon
	 */
	public static final ImageIcon arrow(){
		if(arrow == null)
			arrow = new ImageIcon("images/arrow.png");
		return arrow;
	}
}
