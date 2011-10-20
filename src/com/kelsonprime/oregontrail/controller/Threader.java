package com.kelsonprime.oregontrail.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threader {
	private static ExecutorService cachedPool = Executors.newCachedThreadPool();
	private static ExecutorService singlePool = Executors.newSingleThreadExecutor();
	
	public static void executeNow(Runnable r){
		cachedPool.execute(r);
	}

	public static void executeEventually(Runnable r){
		singlePool.execute(r);
	}
}
