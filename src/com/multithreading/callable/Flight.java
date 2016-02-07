package com.multithreading.callable;

import java.util.concurrent.Callable;

public class Flight implements Callable<String>{

	CallableTester tester = null;
	
	public CallableTester getTester() {
		return tester;
	}

	public void setTester(CallableTester tester) {
		this.tester = tester;
	}

	@Override
	public String call() throws Exception {
		String name = "Shagun";
		Thread.currentThread().sleep(6000);
		return name;
	}

}
