package com.multithreading.runnable.old;

public class Runner implements Runnable{

	@Override
	public void run() {
		try {

			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		System.out.println("Within Runnable Thread:: "
				+ Thread.currentThread().getName());

	}

}
