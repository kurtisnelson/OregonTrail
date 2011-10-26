package com.kelsonprime.oregontrail.model;

import java.util.ArrayList;
import java.util.List;
import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.Ration;
import com.kelsonprime.oregontrail.controller.Time;
import com.kelsonprime.oregontrail.controller.UserInputException;

/**
 * Represents a wagon and it's contents
 * @author Kurt Nelson
 * @version .1
 */
public class Wagon implements Time {
	
	public static final String OXEN = "oxen";
	private int oxen;
	private int food;
	public static final String FOOD = "food";
	private int clothes;
	public static final String CLOTHES = "clothes";
	private int bullets;
	public static final String BULLETS = "bullets";
	private List<Part> activeParts;
	private List<Part> spareParts;
	private List<Companion> party;
	private int money;
	private int wagonWeight;
	static final int MAXWEIGHT = 100;

	/**
	 * Create an empty wagon with fresh parts and put in companions.
	 * @param player The driver of the wagon
	 * @param companions All other party members.
	 * @pre player != null
	 * @post money == 0 && clothes == 0 && oxen == 0 && food == 0 && isReady() == false
	 */
	public Wagon(Player player, List<Companion> companions) {
		party = new ArrayList<Companion>();
		party.add(player);
		party.addAll(companions);
		activeParts = new ArrayList<Part>();
		
		activeParts.add(new Tongue(100));
		activeParts.add(new Axle(100));
		activeParts.add(new Axle(100));
		activeParts.add(new Wheel(100));
		activeParts.add(new Wheel(100));
		activeParts.add(new Wheel(100));
		activeParts.add(new Wheel(100));
		
		spareParts = new ArrayList<Part>();
		money = player.startingMoney();
		bullets = 0;
		clothes = 0;
		food = 0;
		oxen = 0;
		wagonWeight = 0;
	}

	/**
	 * @pre party.length() > 0 && game != null
	 * @invariant money, bullets
	 * @post food < $pre(int, food)
	 */
	@Override
	public void nextDay(Game game) {
		// TODO method stub
		for (Companion person : party){
			person.nextDay(game);
		}
		for (Part part : activeParts){
			part.nextDay(game);
		}
		repair();
		
		Ration ration = game.getRation();
		switch (ration) {
		case BARE: food -= 1;
		case MEAGER: food -= 3;
		case NORMAL: food -= 5;
		case WELLFED: food -= 7;
		}
		if (food < 0 ){
			food = 0;
		}
		//TODO whatever we decide to do with clothes, probably should do something here
	}

	/**
	 * Checks if the user has enough money to spend without debt.
	 * @param moneyNeeded
	 * @return no debt incurred
	 * @pre moneyNeeded >= 0
	 * @invariant money
	 */
	public boolean checkMoney(int moneyNeeded) {
		if(money >= moneyNeeded)
				return true;
		return false;
	}
	
	public int getWeight(){
		return wagonWeight;
	}

	/**
	 * Return how much money is contained in the Wagon
	 * @return money available
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Tries to change amount of money in the wagon by amount
	 * @param amount
	 * @pre amount != 0 && money + amount >= 0
	 * @post money == $pre(int, money) + amount
	 */
	public void changeMoney(int amount) {
		money += amount;
	}
	
	/**
	 * Checks if added weight would overload wagon
	 * @param weight to be added
	 * @return true if wagon would be ok, false if overweight.
	 * @pre weight > 0
	 */
	public boolean checkWeight(int weight){
		return !(wagonWeight + weight > MAXWEIGHT);	
	}
	
	/**
	 * Get how much an instance of a String backed item weighs
	 * @param item Item string constant
	 * @return Weight of item
	 * @pre item == Wagon.BULLETS || item == Wagon.FOOD || item == Wagon.CLOTHES
	 */
	public static int getItemWeight(String item){
		if(item.equals(BULLETS)){
			return 1;
		}else if(item.equals(FOOD)){
			return 5;
		}else if(item.equals(CLOTHES)){
			return 5;
		}
		return 0;
	}
	
	/**
	 * Puts a part in the wagon
	 * @param part Part to add to the wagon
	 * @throws UserInputException If adding the part would make it overweight
	 */
	public void add(Part part) throws UserInputException{
		if(part == null){
			return;
		}else if (checkWeight(part.getWeight())){
			spareParts.add(part);
		}else {
			throw new UserInputException(part + " is too heavy for the Wagon!");
		}
		this.repair();
	}

	/**
	 * Puts a quantity of a String based item in the wagon.
	 * @param item Wagon String constant representing the item
	 * @param quantity Number of item to add
	 * @throws UserInputException If adding the items would make it overweight
	 * @pre item != null && quantity >= 0
	 */
	public void add(String item, int quantity) throws UserInputException{
		if (checkWeight(quantity * getItemWeight(item))){		
			if(item.equals(OXEN)){
				oxen += quantity;
			}else if(item.equals(BULLETS)){
				bullets += quantity;
			}else if(item.equals(FOOD)){
				food += quantity;
			}else if(item.equals(CLOTHES)){
				clothes += quantity;
			}
		}else {
			throw new UserInputException(item + " is too heavy for the wagon!");
		}
	}
	
	/**
	 * Repairs the wagon with available parts
	 * @return Wagon was fully repaired
	 * @post brokenCount >= 0
	 */
	public boolean repair(){
		int brokenCount = 0;
		for (int i = 0; i < activeParts.size(); i++){
			if (activeParts.get(i).getHealth() <= 0){
				Part broken = activeParts.remove(i);
				brokenCount++;
				for (int j = 0; j < spareParts.size(); j++){
					if (broken.getClass().equals(spareParts.get(j).getClass())){
						activeParts.add(spareParts.remove(j));
						brokenCount--;
						break;
					}
				}
			}
		}
		return brokenCount == 0;
	}

	@Override
	public boolean isReady() {
		boolean ready = true;
		repair();
		//Check parts
		int wheel = 0;
		int tongue = 0;
		int axle = 0;
		for(Part part : activeParts){
			if(part instanceof Wheel && part.isReady()){
				wheel++;
			}else if(part instanceof Tongue && part.isReady()){
				tongue++;
			}else if(part instanceof Axle && part.isReady()){
				axle++;
			}
		}
		if(countOxen() < 1)
			ready = false;
		if(axle < 2)
			ready = false;
		if(wheel < 4)
			ready = false;
		if(tongue < 1)
			ready = false;
		//check if player is dead
		for (Companion comp : party){
			if (comp instanceof Player) {
				if (!comp.isReady()){
					ready = false;
					break;
				}
			}
		}
		return ready;		
	}
	
	/**
	 * Count how many oxen are attached to the Wagon
	 * @return Count of oxen
	 */
	public int countOxen(){
		return oxen;
	}
	
	/**
	 * Count how many spare axles are being carried
	 * @return Count of spare axles
	 */
	public int countAxles(){

		int ret=0;
		for(Part part : spareParts){
			if (part instanceof Axle)
				ret++;
		}
		return ret;
	}
	
	/**
	 * Count how many spare wheels are being carried
	 * @return Count of spare wheels
	 */
	public int countWheels(){
		int ret=0;
		for(Part part : spareParts){
			if (part instanceof Wheel)
				ret++;
		}
		return ret;
	}
	
	/**
	 * Count how many spare tongues are being carried
	 * @return Count of spare tongues
	 */
	public int countTongues(){

		int ret=0;
		for(Part part : spareParts){
			if (part instanceof Tongue)
				ret++;
		}
		return ret;
	}
	
	/**
	 * Count how many clothes are in the wagon
	 * @return Count of clothes
	 */
	public int countClothes(){
		return clothes;
	}
	
	/**
	 * Count how many bullets are in the wagon
	 * @return Count of bullets
	 */
	public int countBullets(){
		return bullets;
	}
	
	/**
	 * Count how much food is in the wagon
	 * @return Count of food
	 */
	public int countFood(){
		return food;
	}

}

