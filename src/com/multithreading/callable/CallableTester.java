package com.multithreading.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableTester {
	public static void main(String[] args) {

		Flight callableFlight = new Flight();
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> futureObj = executor.submit(callableFlight);
		
		/**
		 * Do my own stuff here.
		 */
		System.out.println("Busy on main thread");
		
		/**
		 * Done with my work on main thread
		 * check for future obj t see if response has come or not.
		 */
		try {
			String name;
			name = futureObj.get(5000,TimeUnit.MILLISECONDS);
			System.out.println("name ::" + name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("timeout exception");
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main");
	}
}
