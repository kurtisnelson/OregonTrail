package com.kelsonprime.oregontrail.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Threader {
	private static ExecutorService cachedPool = Executors.newCachedThreadPool();
	private static ExecutorService updatePool = Executors.newCachedThreadPool();
	private static ExecutorService singlePool = Executors.newSingleThreadExecutor();
	
	public static void executeNow(Runnable r){
		cachedPool.execute(r);
	}
	
	public static void updator(Runnable r){
		updatePool.shutdownNow();
		try {
			updatePool.awaitTermination(10, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			//This is perfectly ok.
		}
		updatePool.execute(r);
	}
	public static void executeEventually(Runnable r){
		singlePool.execute(r);
	}
}
