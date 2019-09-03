package com.example.monitor;

import java.security.SecureRandom;

public class MyClass implements Runnable {

	private final String name;

	private final int sleepTime;

	private final SecureRandom random = new SecureRandom();

	public MyClass(String name) {
		this.name = name;
		this.sleepTime = random.nextInt(5000);
	}

	public String getName() {
		return name;
	}

	public int getSleepTime() {
		return sleepTime;
	}
	@Override
	public void run() {
		synchronized (this) {
			System.out.println("Sleeping for " + sleepTime + " ms");
			try {
				Thread.sleep(sleepTime);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread()
					.interrupt();
			}
			System.out.println("Finished Sleeping for " + sleepTime + " ms");
		}
	}
}
