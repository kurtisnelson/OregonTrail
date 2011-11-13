package com.kelsonprime.oregontrail.model.test;

import org.junit.*;
import static org.junit.Assert.*;
import com.kelsonprime.oregontrail.model.Game;
import com.kelsonprime.oregontrail.model.Landmark;
import com.kelsonprime.oregontrail.model.Location;
import com.kelsonprime.oregontrail.model.Map;
import com.kelsonprime.oregontrail.model.Pace;

/**
 * The class <code>MapTest</code> contains tests for the class <code>{@link Map}</code>.
 *
 * @generatedBy CodePro at 11/13/11 3:16 PM
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class MapTest {
	/**
	 * Run the Map(Location) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testMap_1()
		throws Exception {
		Location start = new Landmark("", 1);

		Map result = new Map(start);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.isReady());
		assertEquals(0, result.getTraveled());
	}

	/**
	 * Run the Location currentLocation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testCurrentLocation_1()
		throws Exception {
		Map fixture = MapFactory.createEmptyMap();

		Location result = fixture.currentLocation();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRoadLength());
		assertEquals("Start", result.toString());
		assertEquals(null, result.next());
		assertEquals(0, result.getPosition());
	}

	/**
	 * Run the int distanceBetween(Location,Location) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testDistanceBetween_1()
		throws Exception {
		Location start = null;
		Location end = new Landmark("", 1);

		int result = Map.distanceBetween(start, end);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int distanceBetween(Location,Location) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testDistanceBetween_2()
		throws Exception {
		Location start = new Landmark("", 1);
		Location end = null;

		int result = Map.distanceBetween(start, end);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int distanceBetween(Location,Location) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testDistanceBetween_3()
		throws Exception {
		Location start = new Landmark("", 1);
		Location end = new Landmark("", 1);

		int result = Map.distanceBetween(start, end);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int distanceToNext() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testDistanceToNext_1()
		throws Exception {
		Map fixture = MapFactory.createShortMap();

		int result = fixture.distanceToNext();

		// add additional test code here
		assertEquals(50, result);
	}

	/**
	 * Run the int getTraveled() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testGetTraveled_1()
		throws Exception {
		Map fixture = MapFactory.createEmptyMap();

		int result = fixture.getTraveled();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the boolean isReady() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testIsReady_1()
		throws Exception {
		Map fixture = MapFactory.createShortMap();

		boolean result = fixture.isReady();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the Map mapFactory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testMapFactory_1()
		throws Exception {

		Map result = Map.mapFactory();

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.isReady());
		assertEquals(10, result.distanceToNext());
		assertEquals(0, result.getTraveled());
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testNextDay_1()
		throws Exception {
		Map fixture = MapFactory.createShortMap();
		Game game = new Game(WagonFactory.createWagon());
		game.setPace(Pace.GRUELING);

		fixture.nextDay(game);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.kelsonprime.oregontrail.model.Map.nextLocation(Map.java:52)
		//       at com.kelsonprime.oregontrail.model.Map.distanceToNext(Map.java:62)
		//       at com.kelsonprime.oregontrail.model.Map.travel(Map.java:82)
		//       at com.kelsonprime.oregontrail.model.Map.nextDay(Map.java:139)
	}

	/**
	 * Run the Location nextLocation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testNextLocation_1()
		throws Exception {
		Map fixture = MapFactory.createShortMap();

		Location result = fixture.nextLocation();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getRoadLength());
		assertEquals("The End", result.toString());
		assertEquals(null, result.next());
		assertEquals(50, result.getPosition());
	}

	/**
	 * Run the Location nextLocation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testNextLocation_2()
		throws Exception {
		Map fixture = MapFactory.createShortMap();

		Location result = fixture.nextLocation();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.kelsonprime.oregontrail.model.Map.nextLocation(Map.java:52)
		assertNotNull(result);
	}

	/**
	 * Run the Location travel(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testTravel_1()
		throws Exception {
		Map fixture = MapFactory.createShortMap();
		int distance = 1;

		Location result = fixture.travel(distance);
		assertNull(result);
	}

	/**
	 * Run the Location travel(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Test
	public void testTravel_2()
		throws Exception {
		Map fixture = MapFactory.createShortMap();
		int distance = 1;

		Location result = fixture.travel(distance);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 11/13/11 3:16 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MapTest.class);
	}
}