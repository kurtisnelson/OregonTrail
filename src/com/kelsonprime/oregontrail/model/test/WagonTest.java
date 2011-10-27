package com.kelsonprime.oregontrail.model.test;

import java.util.LinkedList;
import java.util.List;
import org.junit.*;

import static org.junit.Assert.*;
import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.Ration;
import com.kelsonprime.oregontrail.controller.UserInputException;
import com.kelsonprime.oregontrail.model.Axle;
import com.kelsonprime.oregontrail.model.Banker;
import com.kelsonprime.oregontrail.model.Companion;
import com.kelsonprime.oregontrail.model.Item;
import com.kelsonprime.oregontrail.model.Part;
import com.kelsonprime.oregontrail.model.Player;
import com.kelsonprime.oregontrail.model.Tongue;
import com.kelsonprime.oregontrail.model.Wagon;
import com.kelsonprime.oregontrail.model.Wheel;

/**
 * The class <code>WagonTest</code> contains tests for the class <code>{@link Wagon}</code>.
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
	public void testWagon_1()
		throws Exception {
		Player player = new Player("", new Banker());
		List<Companion> companions = new LinkedList<Companion>();

		Wagon result = new Wagon(player, companions);

		// add additional test code here
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
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();
		Part part = null;

		fixture.add(part);
		assertEquals(0, fixture.countAxles());
		assertEquals(0, fixture.countTongues());
		assertEquals(0, fixture.countWheels());
		Part part2 = new Tongue();
		fixture.add(part2);
		assertEquals(0, fixture.countAxles());
		assertEquals(1, fixture.countTongues());
		assertEquals(0, fixture.countWheels());
		Part part3 = new Wheel();
		fixture.add(part3);
		assertEquals(0, fixture.countAxles());
		assertEquals(1, fixture.countTongues());
		assertEquals(1, fixture.countWheels());
		assertEquals(Part.getWeight(part2) + Part.getWeight(part3), fixture.getWeight());
	}

	/**
	 * Run the void add(Part) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testAdd_2()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
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
		assertEquals(Part.getWeight(part) + Part.getWeight(part2) + Part.getWeight(part3), fixture.getWeight());
	}

	/**
	 * Run the void add(Part) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testAdd_3()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();
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
		assertEquals(Part.getWeight(part) + Part.getWeight(part2) + Part.getWeight(part3), fixture.getWeight());
		// add additional test code here
	}

	/**
	 * Run the void add(String,int) method tests.
	 * @throws Exception
	 */
	@Test
	public void testAdd()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		testAdd(fixture);
		fixture = WagonFactory.createWagon2();
		testAdd(fixture);
	}
	
	public void testAdd(Wagon fixture) throws Exception{
		int quantity = 1;
		fixture.add(Item.BULLETS, quantity);
		assertEquals(Item.BULLETS.getWeight()*quantity, fixture.getWeight());
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
		try{
			int weight = fixture.getWeight();
			int count = (weight + 1)/Item.BULLETS.getWeight();
			fixture.add(Item.BULLETS, 2000);
		}catch(UserInputException e){
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
	public void nullAdd()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();
		int quantity = 1;
		boolean thrown = false;
		try{
		fixture.add(null, quantity);
		}catch(NullPointerException e){
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
	public void testChangeMoney_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		int amount = 1;

		fixture.changeMoney(amount);

		// add additional test code here
	}

	/**
	 * Run the boolean checkMoney(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCheckMoney_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		int moneyNeeded = 1;

		boolean result = fixture.checkMoney(moneyNeeded);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean checkMoney(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCheckMoney_2()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();
		int moneyNeeded = 1;

		boolean result = fixture.checkMoney(moneyNeeded);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean checkWeight(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCheckWeight_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();
		int weight = 1;

		boolean result = fixture.checkWeight(weight);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean checkWeight(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCheckWeight_2()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		int weight = 1;

		boolean result = fixture.checkWeight(weight);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the int countAxles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountAxles_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.countAxles();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countAxles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountAxles_2()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countAxles();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countAxles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountAxles_3()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.countAxles();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countBullets() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountBullets_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.countBullets();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countClothes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountClothes_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countClothes();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countFood() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountFood_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countFood();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countOxen() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountOxen_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countOxen();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countTongues() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountTongues_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.countTongues();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countTongues() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountTongues_2()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countTongues();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countTongues() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountTongues_3()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.countTongues();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countWheels() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountWheels_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countWheels();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countWheels() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountWheels_2()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.countWheels();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int countWheels() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testCountWheels_3()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.countWheels();

		// add additional test code here
		assertEquals(0, result);
	}


	/**
	 * Run the int getMoney() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testGetMoney_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		int result = fixture.getMoney();

		// add additional test code here
		assertEquals(2000, result);
	}

	/**
	 * Run the int getWeight() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testGetWeight_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		int result = fixture.getWeight();

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the boolean isReady() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testIsReady_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		boolean result = fixture.isReady();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isReady() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testIsReady_2()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		boolean result = fixture.isReady();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isReady() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testIsReady_3()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		boolean result = fixture.isReady();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isReady() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testIsReady_4()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		boolean result = fixture.isReady();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isReady() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testIsReady_5()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		boolean result = fixture.isReady();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isReady() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testIsReady_6()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		boolean result = fixture.isReady();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_2()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_3()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_4()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_5()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_6()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_7()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_8()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_9()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_10()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_11()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_12()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_13()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_14()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_15()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the void nextDay(Game) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testNextDay_16()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();
		Game game = new Game(WagonFactory.createWagon2());
		game.setRation(Ration.BARE);

		fixture.nextDay(game);

		// add additional test code here
	}

	/**
	 * Run the boolean repair() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testRepair_1()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		boolean result = fixture.repair();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean repair() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testRepair_2()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		boolean result = fixture.repair();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean repair() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testRepair_3()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		boolean result = fixture.repair();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean repair() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testRepair_4()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon2();

		boolean result = fixture.repair();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean repair() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	@Test
	public void testRepair_5()
		throws Exception {
		Wagon fixture = WagonFactory.createWagon();

		boolean result = fixture.repair();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 10/26/11 1:23 AM
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
	 * @generatedBy CodePro at 10/26/11 1:23 AM
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
	 * @generatedBy CodePro at 10/26/11 1:23 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(WagonTest.class);
	}
}