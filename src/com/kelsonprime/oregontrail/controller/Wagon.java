package com.kelsonprime.oregontrail.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.kelsonprime.oregontrail.model.Part;

public class Wagon implements PassDay {

	private int oxen;
	private int food;
	private int clothes;
	private int bullets;
	private Collection<Part> activeParts;
	private Collection<Part> spareParts;
	private Collection<Companion> party;
	private int money;

	public Wagon(Player player, List<Companion> companions) {
		party = new ArrayList<Companion>();
		party.add(player);
		party.addAll(companions);
		activeParts = new ArrayList<Part>();
		// TODO setup intial parts
		spareParts = new ArrayList<Part>();
		money = player.startingMoney();
		bullets = 0;
		clothes = 0;
		food = 0;
		oxen = 0;
	}

	/**
	 * 
	 * @param game
	 */
	@Override
	public void passDay(Game game) {
		// TODO method stub
	}

	/**
	 * 
	 * @param moneyNeeded
	 */
	public boolean checkMoney(int moneyNeeded) {
		// TODO method stub
		return false;
	}

	public int getMoney() {
		return money;
	}

	/**
	 * 
	 * @param moneyUsed
	 */
	public boolean spendMoney(int amount) {
		if (checkMoney(amount)) {
			money -= amount;
			return true;
		}
		return false;
	}

}
