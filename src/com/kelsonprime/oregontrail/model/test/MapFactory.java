package com.kelsonprime.oregontrail.model.test;

import com.kelsonprime.oregontrail.model.Destination;
import com.kelsonprime.oregontrail.model.Map;
import com.kelsonprime.oregontrail.model.Shop;


/**
 * The class <code>MapFactory</code> implements static methods that return instances of the class <code>{@link Map}</code>.
 *
 * @generatedBy CodePro at 11/13/11 2:58 PM
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class MapFactory
 {
	/**
	 * Prevent creation of instances of this class.
	 *
	 * @generatedBy CodePro at 11/13/11 2:58 PM
	 */
	private MapFactory() {
	}


	/**
	 * Create an instance of the class <code>{@link Map}</code>.
	 *
	 * @generatedBy CodePro at 11/13/11 2:58 PM
	 */
	public static Map createEmptyMap() {
		return new Map(new Shop("Start", 0));
	}
	
	public static Map createShortMap() {
		Shop inde = new Shop("Starting Shop", 0);
		Map result = new Map(inde);
		Destination end = new Destination("The End", 50);
		inde.setNext(end, 15, 0);
		return result;
	}
}