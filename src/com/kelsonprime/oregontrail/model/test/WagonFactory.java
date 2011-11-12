package com.kelsonprime.oregontrail.model.test;

import java.util.ArrayList;
import java.util.LinkedList;
import com.kelsonprime.oregontrail.model.Banker;
import com.kelsonprime.oregontrail.model.Carpenter;
import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Player;
import com.kelsonprime.oregontrail.model.Wagon;


/**
 * The class <code>WagonFactory</code> implements static methods that return instances of the class <code>{@link Wagon}</code>.
 *
 * @author Kurt Nelson
 * @version $Revision: 1.0 $
 */
class WagonFactory
 {
	/**
	 * Prevent creation of instances of this class.
	 */
	private WagonFactory() {
	}


	/**
	 * Create an instance of the class <code>{@link Wagon}</code> with the <code>Player</code> as a <code>Banker</code>
	 */
	public static Wagon createWagon() {
		ArrayList<Companion> list = new ArrayList<Companion>();
		list.add(new Companion(""));
		return new Wagon(new Player("", new Banker()), list);
	}


	/**
	 * Create an instance of the class <code>{@link Wagon}</code> with the <code>Player</code> as a <code>Carpenter</code>
	 */
	public static Wagon createWagon2() {
		LinkedList<Companion> list = new LinkedList<Companion>();
		list.add(new Companion(""));
		return new Wagon(new Player("0123456789", new Carpenter()), list);
	}
}