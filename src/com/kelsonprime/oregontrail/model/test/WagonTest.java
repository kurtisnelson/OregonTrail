// $codepro.audit.disable
package com.kelsonprime.oregontrail.model.test;

import java.util.LinkedList;
import java.util.List;
import org.junit.*;

import static org.junit.Assert.*;
import com.kelsonprime.oregontrail.controller.UserInputException;
import com.kelsonprime.oregontrail.model.Axle;
import com.kelsonprime.oregontrail.model.Banker;
import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Game;
import com.kelsonprime.oregontrail.model.Item;
import com.kelsonprime.oregontrail.model.Part;
import com.kelsonprime.oregontrail.model.Player;
import com.kelsonprime.oregontrail.model.Ration;
import com.kelsonprime.oregontrail.model.Tongue;
import com.kelsonprime.oregontrail.model.Wagon;
import com.kelsonprime.oregontrail.model.Wheel;

/**
 * The class <code>WagonTest</code> contains tests for the class
 * <code>{@link Wagon}</code>.
 * 
 * @generatedBy CodePro at 10/26/11 1:23 AM
 * @author kurt
 * @version $Revision: 1.0 $
 */
public class WagonTest {
	/**
	 * Run the Wagon(Player,List<Companion>) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void wagonCreation() throws Exception {
		Player player = new Player("", new Banker());
		List<Companion> companions = new LinkedList<Companion>();

		Wagon result = new Wagon(player, companions);

		assertNotNull(result);
		assertEquals(0, result.countClothes());
		assertEquals(0, result.countOxen());
		assertEquals(0, result.countFood());
		assertEquals(0, result.countAxles());
		assertEquals(0, result.countTongues());
		assertEquals(3000, result.getMoney());
		assertEquals(0, result.countWheels());
		assertEquals(0, result.countBullets());
		assertEquals(true, result.repair());
		assertEquals(0, result.getWeight());
		assertEquals(false, result.isReady());
	}

	/**
	 * Run the void add(Part) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void addParts() throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		addParts(fixture);
		fixture = WagonFactory.createWagon2();
		addParts(fixture);
	}
	
	public void addParts(Wagon fixture) throws Exception {
		fixture.add(null);
		Part part = new Axle();
		fixture.add(part);
		assertEquals(1, fixture.countAxles());
		assertEquals(0, fixture.countTongues());
		assertEquals(0, fixture.countWheels());
		Part part2 = new Tongue();
		fixture.add(part2);
		assertEquals(1, fixture.countAxles());
		assertEquals(1, fixture.countTongues());
		assertEquals(0, fixture.countWheels());
		Part part3 = new Wheel();
		fixture.add(part3);
		assertEquals(1, fixture.countAxles());
		assertEquals(1, fixture.countTongues());
		assertEquals(1, fixture.countWheels());
		assertEquals(
				Part.getWeight(part) + Part.getWeight(part2)
						+ Part.getWeight(part3), fixture.getWeight());
	}

	/**
	 * Run the void add(String,int) method tests.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdd() throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		testAdd(fixture);
		fixture = WagonFactory.createWagon2();
		testAdd(fixture);
	}

	public void testAdd(Wagon fixture) throws Exception {
		int quantity = 1;
		fixture.add(Item.BULLETS, quantity);
		assertEquals(Item.BULLETS.getWeight() * quantity, fixture.getWeight());
		assertEquals(0, fixture.countAxles());
		assertEquals(1, fixture.countBullets());
		fixture.add(Item.CLOTHES, 1);
		assertEquals(1, fixture.countClothes());
		fixture.add(Item.CLOTHES, 5);
		assertEquals(6, fixture.countClothes());
		fixture.add(Item.BULLETS, 100);
		assertEquals(101, fixture.countBullets());
		fixture.add(Item.OXEN, 2);
		fixture.add(Item.FOOD, 879);
		assertEquals(2, fixture.countOxen());
		assertEquals(879, fixture.countFood());
		assertEquals(0, fixture.countAxles());

		boolean thrown = false;
		try {
			fixture.add(Item.BULLETS, Wagon.MAXWEIGHT/Item.BULLETS.getWeight() +1);
		} catch (UserInputException e) {
			thrown = true;
		}
		assertTrue("Wagon overweight exception not thrown", thrown);
	}

	/**
	 * Run the void add(null,int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void nullAdd() throws Exception {
		Wagon fixture = WagonFactory.createWagon2();
		int quantity = 1;
		boolean thrown = false;
		try {
			fixture.add(null, quantity);
		} catch (NullPointerException e) {
			thrown = true;
		}
		assertTrue("Add method did not fail on invalid Item", thrown);
	}

	/**
	 * Run the void changeMoney(int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void changeMoney() throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		fixture.changeMoney(-1000);
		assertEquals(2000, fixture.getMoney());
		fixture.changeMoney(-2000);
		assertEquals(0, fixture.getMoney());
	}

	/**
	 * Run the boolean checkMoney(int) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void checkMoney() throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		assertTrue("Does not have 1000 money to spend", fixture.hasMoney(1000));
		assertTrue("Does not have 2000 money to spend", fixture.hasMoney(2000));
		assertTrue("Does not have 3000 money to spend", fixture.hasMoney(3000));
		assertTrue("Cannot recieve 3000 money", fixture.hasMoney(-3000));
		assertFalse("Has 3001 money to spend", fixture.hasMoney(3001));
	}

	/**
	 * Run the int countAxles() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void countAxles() throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.countAxles();

		assertEquals(0, result);
		
		fixture.add(new Axle());
		assertEquals(1, fixture.countAxles());
	}

	/**
	 * Run the int countBullets() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void countBullets() throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.countBullets();

		assertEquals(0, result);
		
		fixture.add(Item.BULLETS, 5);
		assertEquals(5, fixture.countBullets());
	}

	/**
	 * Run the int countClothes() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void countClothes() throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countClothes();

		assertEquals(0, result);
		
		fixture.add(Item.CLOTHES, 5);
		assertEquals(5, fixture.countClothes());
	}

	/**
	 * Run the int countFood() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void countFood() throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countFood();

		assertEquals(0, result);
		
		fixture.add(Item.FOOD, 5);
		assertEquals(5, fixture.countFood());
	}

	/**
	 * Run the int countOxen() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void countOxen() throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countOxen();

		assertEquals(0, result);
		
		fixture.add(Item.OXEN, 5);
		assertEquals(5, fixture.countOxen());
	}

	/**
	 * Run the int countTongues() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void countTongues() throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.countTongues();

		assertEquals(0, result);
		fixture.add(new Tongue());
		assertEquals(1, fixture.countTongues());
	}


	/**
	 * Run the int countWheels() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void countWheels() throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countWheels();

		assertEquals(0, result);
		fixture.add(new Wheel());
		assertEquals(1, fixture.countWheels());
	}

	/**
	 * Run the int getMoney() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getMoney() throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.getMoney();

		assertEquals(2000, result);
	}

	/**
	 * Run the int getWeight() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getWeight() throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.getWeight();

		assertEquals(0, result);
	}

	/**
	 * Run the boolean isReady() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void isReady() throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		boolean result = fixture.isReady();

		assertEquals(false, result);
	}

	/**
	 * Run the boolean isReady() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void isReady2() throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		boolean result = fixture.isReady();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void nextDay(Game) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void nextDay() throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(fixture);
		game.setRation(Ration.BARE);

		fixture.nextDay(game);
	}

	/**
	 * Run the boolean repair() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void repair() throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		boolean result = fixture.repair();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(WagonTest.class);
	}
}