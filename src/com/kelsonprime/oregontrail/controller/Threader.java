package com.kelsonprime.oregontrail.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Splits functions into threads
 * 
 * @author Aman
 * 
 */
public class Threader {
	private static ExecutorService cachedPool = Executors.newCachedThreadPool();
	private static ExecutorService singlePool = Executors
			.newSingleThreadExecutor();

	/**
	 * Executes now efficiently
	 * 
	 * Instead of just executing a Runnable directly elsewhere, this method
	 * should be used to try and use existing thread processes when possible.
	 * 
	 * @param r
	 *            Task to execute
	 */
	public static void executeNow(Runnable r) {
		cachedPool.execute(r);
	}

	/**
	 * Executes using a queue
	 * 
	 * @param r
	 *            Task to enqueue
	 */
	public static void executeEventually(Runnable r) {
		singlePool.execute(r);
	}
}
