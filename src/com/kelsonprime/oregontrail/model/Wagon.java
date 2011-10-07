package com.kelsonprime.oregontrail.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.kelsonprime.oregontrail.controller.Companion;
import com.kelsonprime.oregontrail.controller.Game;
import com.kelsonprime.oregontrail.controller.PassDay;
import com.kelsonprime.oregontrail.controller.Player;

public class Wagon implements PassDay {

	private int oxen;
	private int food;
	private int clothes;
	private int bullets;
	private Collection<Part> activeParts;
	private Collection<Part> spareParts;
	private Collection<Companion> party;
	private int money;

	/**
	 * Create an empty wagon with fresh parts and put in companions.
	 * @param player The driver of the wagon
	 * @param companions All other party members.
	 * @pre player != null
	 * @post money == 0 && clothes == 0 && oxen == 0 && food == 0
	 */
	public Wagon(Player player, List<Companion> companions) {
		party = new ArrayList<Companion>();
		party.add(player);
		party.addAll(companions);
		activeParts = new ArrayList<Part>();
		// TODO setup initial parts
		spareParts = new ArrayList<Part>();
		money = player.startingMoney();
		bullets = 0;
		clothes = 0;
		food = 0;
		oxen = 0;
	}

	/**
	 * Simulate one night passing for all wagon contents
	 * @param game
	 * @pre party.length() > 0 && game != null
	 * @invariant money, bullets
	 * @post food < $pre(int, food)
	 */
	@Override
	public void passDay(Game game) {
		// TODO method stub
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

}
