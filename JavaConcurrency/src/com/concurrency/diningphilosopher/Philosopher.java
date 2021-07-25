package com.concurrency.diningphilosopher;

import java.util.Scanner;

public class Philosopher implements Runnable {
	private int id;
	private DiningPhilosophers dining;
	private long diningTime;

	public Philosopher(int id, DiningPhilosophers dining, long diningTime) {
		this.id = id;
		this.dining = dining;
	}

	@Override
	public void run() {
		try {
			eatNumberOfTimes(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void eatNumberOfTimes(int n) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			dining.wantsToEat(id, diningTime);
		}
	}

	public void eatForGivenTime(int id, DiningPhilosophers dining, long diningTime) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("for how much time does philosopher ::  " + id + "  :: want to eat?");
		long time = sc.nextLong();
		while (time != 0) {
			dining.wantsToEat(id, time);
			time = sc.nextLong();
		}
		sc.close();
	}

}
