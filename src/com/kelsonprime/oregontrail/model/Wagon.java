package com.kelsonprime.oregontrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.kelsonprime.oregontrail.controller.Events;
import com.kelsonprime.oregontrail.controller.UserInputException;

/**
 * Represents a wagon and it's contents
 * 
 * @author Kurt Nelson
 * @version .1
 */
public class Wagon implements Time, Serializable {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 5643405898536801840L;

	/**
	 * @serial Number of oxen
	 */
	private int oxen;

	/**
	 * @serial Amount of food
	 */
	private int food;

	/**
	 * @serial Amount of clothes
	 */
	private int clothes;

	/**
	 * @serial Number of bullets
	 */
	private int bullets;

	/**
	 * @serial Parts being used to move
	 */
	private final List<Part> activeParts;

	/**
	 * @serial Parts kept as spares
	 */
	private final List<Part> spareParts;

	/**
	 * @serial People in the wagon
	 */
	private final List<Companion> party;

	/**
	 * Money in the wagon
	 */
	private int money;

	/**
	 * Weight of the wagon
	 */
	private int wagonWeight;

	/**
	 * Maximum weight capacity of a wagon
	 */
	public static final int MAXWEIGHT = 2000;

	/**
	 * Create an empty wagon with fresh parts and put in companions.
	 * 
	 * @param player
	 *            The driver of the wagon
	 * @param companions
	 *            All other party members.
	 * @pre player != null
	 * @post money == 0 && clothes == 0 && oxen == 0 && food == 0 && isReady()
	 *       == false
	 */
	public Wagon(Player player, List<Companion> companions) {
		party = new ArrayList<Companion>();
		party.add(player);
		party.addAll(companions);
		activeParts = new ArrayList<Part>();

		activeParts.add(new Tongue());
		activeParts.add(new Axle());
		activeParts.add(new Axle());
		activeParts.add(new Wheel());
		activeParts.add(new Wheel());
		activeParts.add(new Wheel());
		activeParts.add(new Wheel());

		spareParts = new ArrayList<Part>();
		money = player.startingMoney();
		bullets = 0;
		clothes = 0;
		food = 0;
		oxen = 0;
		wagonWeight = 0;
	}

	/**
	 * Progress a day in time
	 * 
	 * @pre party.length() > 0 && game != null
	 * 
	 * @post food < $pre(int, food)
	 * @param game
	 *            Game
	 * @see com.kelsonprime.oregontrail.model.Time#nextDay(Game)
	 */
	@Override
	public void nextDay(Game game) {
		// TODO take current location into account.
		for (Companion person : party) {
			if (person.isReady())
				person.nextDay(game);
		}
		for (Part part : activeParts) {
			part.nextDay(game);
		}
		repair(); // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue

		// Eat some food.
		food -= game.getRation().getPortion() * party.size();

		if (food < 0) {
			food = 0;
		}
		// TODO whatever we decide to do with clothes, probably should do
		// something here
		Events.nextDay(game);
	}

	/**
	 * Checks if the user has enough money to spend without debt.
	 * 
	 * @param moneyNeeded
	 * 
	 * @pre moneyNeeded >= 0
	 * 
	 * @return no debt incurred
	 */
	public boolean hasMoney(int moneyNeeded) {
		if (money >= moneyNeeded){
			return true;
		}
		return false;
	}

	/**
	 * Method getWeight.
	 * 
	 * @return int
	 */
	public int getWeight() {
		return wagonWeight;
	}

	/**
	 * Return how much money is contained in the Wagon
	 * 
	 * 
	 * @return money available
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Changes amount of money in the wagon
	 * 
	 * @param amount
	 * @post money == $pre(int, money) + amount
	 */
	public void changeMoney(int amount) {
		money += amount;
	}

	/**
	 * Checks if added weight would overload wagon
	 * 
	 * @param weight
	 *            to be added
	 * 
	 * @pre weight > 0
	 * @return true if wagon would be ok, false if overweight.
	 */
	public boolean canAddWeight(int weight) {
		return !(wagonWeight + weight > MAXWEIGHT);
	}

	/**
	 * Method addWeight.
	 * 
	 * @param weight
	 *            int
	 */
	public void addWeight(int weight) {
		wagonWeight += weight;
	}

	/**
	 * Puts a part in the wagon
	 * 
	 * @param part
	 *            Part to add to the wagon
	 * 
	 * @throws UserInputException
	 *             If adding the part would make it overweight
	 */
	public void add(Part part) throws UserInputException {
		if (part == null) {
			return;
		} else if (canAddWeight(Part.getWeight(part))) {
			spareParts.add(part);
		} else {
			throw new UserInputException(part + " is too heavy for the Wagon!");
		}
		addWeight(Part.getWeight(part));
		this.repair(); // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue
	}

	/**
	 * Puts a quantity of a Item in the wagon.
	 * 
	 * @param item
	 *            Item type
	 * @param quantity
	 *            Number of item to add
	 * 
	 * @pre item != null && quantity >= 0
	 * @throws UserInputException
	 *             If adding the items would make it overweight
	 */
	public void add(Item item, int quantity) throws UserInputException {
		if (canAddWeight(quantity * item.getWeight())) {
			switch (item) { // $codepro.audit.disable missingDefaultInSwitch
			case OXEN:
				oxen += quantity;
				break;
			case BULLETS:
				bullets += quantity;
				break;
			case FOOD:
				food += quantity;
				break;
			case CLOTHES:
				clothes += quantity;
				break;
			}
			addWeight(item.getWeight() * quantity);
		} else {
			throw new UserInputException(item + " is too heavy for the wagon!");
		}
	}

	/**
	 * removes one random item from the wagon
	 * 
	 * @return String what was removed
	 */
	public String removeRandomItem() {

		final int itemCt = countItems();
		final int foodRatio = food;
		final int clothesRatio = foodRatio + clothes;
		final int bulletRatio = clothesRatio + bullets;
		final int wheelRatio = bulletRatio + countWheels();
		final int axleRatio = wheelRatio + countAxles();

		if (itemCt > 0) {
			final Random rnd = new Random();
			final int i = rnd.nextInt(itemCt);
			if (i < foodRatio) {
				food -= 1;
				return "food";
			} else if (i < clothesRatio) {
				clothes -= 1;
				return "clothes";
			} else if (i < bulletRatio) {
				bullets -= 1;
				return "bullet";
			} else if (i < wheelRatio) {
				spareParts.remove(new Wheel());
				return "wheel";
			} else if (i < axleRatio) {
				spareParts.remove(new Axle());
				return "axle";
			} else if (spareParts.contains(new Tongue())) {
				spareParts.remove(new Tongue());
				return "tongue";
			}
		}
		return null;
	}

	/**
	 * Repairs the wagon with available parts
	 * 
	 * 
	 * @post brokenCount >= 0
	 * @return Wagon was fully repaired
	 */
	public boolean repair() { // $codepro.audit.disable
								// booleanMethodNamingConvention
		int brokenCount = 0;
		for (int i = 0; i < activeParts.size(); i++) {
			if (activeParts.get(i).getHealth() <= 0) {
				Part broken = activeParts.remove(i);
				brokenCount++;
				for (int j = 0; j < spareParts.size(); j++) {
					if (broken.getClass().equals(spareParts.get(j).getClass())) {
						activeParts.add(spareParts.remove(j));
						brokenCount--;
						break;
					}
				}
			}
		}
		return brokenCount == 0;
	}

	/**
	 * Method isReady.
	 * 
	 * @return boolean
	 * @see com.kelsonprime.oregontrail.model.Time#isReady()
	 */
	@Override
	public boolean isReady() {
		boolean ready = true;
		repair(); // $codepro.audit.disable
					// com.instantiations.assist.eclipse.analysis.unusedReturnValue
		// Check parts
		int wheel = 0;
		int tongue = 0;
		int axle = 0;
		for (Part part : activeParts) {
			if (part instanceof Wheel && part.isReady()) {
				wheel++;
			} else if (part instanceof Tongue && part.isReady()) {
				tongue++;
			} else if (part instanceof Axle && part.isReady()) {
				axle++;
			}
		}
		if (countOxen() < 1) {
			ready = false;
		}
		if (axle < 2) {
			ready = false;
		}
		if (wheel < 4) {
			ready = false;
		}
		if (tongue < 1) {
			ready = false;
		}
		// check if player is dead
		for (Companion comp : party) {
			if (comp instanceof Player) {
				if (!comp.isReady()) {
					ready = false;
					break;
				}
			}
		}
		return ready;
	}

	/**
	 * count how many items are in the wagon
	 * 
	 * @return number of items in the wagon
	 */
	public int countItems() {
		return food + clothes + bullets + spareParts.size();
	}

	/**
	 * Count how many oxen are attached to the Wagon
	 * 
	 * 
	 * @return Count of oxen
	 */
	public int countOxen() {
		return oxen;
	}

	/**
	 * Count how many spare axles are being carried
	 * 
	 * 
	 * @return Count of spare axles
	 */
	public int countAxles() {

		int ret = 0;
		for (Part part : spareParts) {
			if (part instanceof Axle)
				ret++;
		}
		return ret;
	}

	/**
	 * Count how many spare wheels are being carried
	 * 
	 * 
	 * @return Count of spare wheels
	 */
	public int countWheels() {
		int ret = 0;
		for (Part part : spareParts) {
			if (part instanceof Wheel)
				ret++;
		}
		return ret;
	}

	/**
	 * Count how many spare tongues are being carried
	 * 
	 * 
	 * @return Count of spare tongues
	 */
	public int countTongues() {

		int ret = 0;
		for (Part part : spareParts) {
			if (part instanceof Tongue)
				ret++;
		}
		return ret;
	}

	/**
	 * Count how many clothes are in the wagon
	 * 
	 * 
	 * @return Count of clothes
	 */
	public int countClothes() {
		return clothes;
	}

	/**
	 * Count how many bullets are in the wagon
	 * 
	 * 
	 * @return Count of bullets
	 */
	public int countBullets() {
		return bullets;
	}

	/**
	 * Count how much food is in the wagon
	 * 
	 * 
	 * @return Count of food
	 */
	public int countFood() {
		return food;
	}

	/**
	 * Method removeCompanion.
	 * 
	 * @param companion
	 *            Companion
	 */
	public void removeCompanion(Companion companion) {
		party.remove(companion);
	}

	/**
	 * Find the player
	 * 
	 * @return player
	 */
	public Player getPlayer() {
		for (int i = 0; i < party.size(); i++) {
			if (party.get(i) instanceof Player)
				return (Player) party.get(i);
		}
		return null;
	}

	/**
	 * Kill a random party member
	 */
	public void killRandomPartyMember() {
		final Random rand = new Random();
		Companion c = party.get(rand.nextInt(party.size() - 1));
		while (!(c.isReady() || c instanceof Player)) {
			c = party.get(rand.nextInt(party.size() - 1));
		}
		Events.death(this, c);
	}
	
	public void giveRandomSickness() {
		final Random rand = new Random();
		Companion c = party.get(rand.nextInt(party.size() - 1));
		while (!(c.isReady())) {
			c = party.get(rand.nextInt(party.size() - 1));
		}
		c.becomeSick();
		JOptionPane.showMessageDialog(null, c.toString() + " has become sick with Dysentery!");
	}

	/**
	 * Standard toString
	 * 
	 * @return name
	 */
	@Override public String toString() {
		return "A wagon with " + party.size() + " people in it.";
	}
	
	public List<Companion> getParty(){
		return party;
	}
}
