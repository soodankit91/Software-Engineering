package com.concurrency.diningphilosopher;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

	Semaphore[] forks;

	public DiningPhilosophers(int n) {
		forks = new Semaphore[n];

		for (int i = 0; i < n; i++) {
			forks[i] = new Semaphore(1);
		}
	}

	public void wantsToEat(int philosopher, long diningTime) throws InterruptedException {
		if (philosopher % 2 == 0) {
			pickLeftFork(philosopher);
		} else {
			pickRightFork(philosopher);
		}
		System.out.println("philosopher :: " + philosopher + " :: is eating");
		Thread.sleep(diningTime);
		returnForks(philosopher);
	}

	private void pickRightFork(int philosopher) throws InterruptedException {
		forks[philosopher].acquire();
		System.out.println("philosopher :: " + philosopher + " :: has picked the right fork");

		forks[(philosopher + 1) % 5].acquire();
		System.out.println("philosopher :: " + philosopher + " :: has picked the left fork");
	}

	private void pickLeftFork(int philosopher) throws InterruptedException {
		forks[(philosopher + 1) % 5].acquire();
		System.out.println("philosopher :: " + philosopher + " :: has picked the left fork");

		forks[philosopher].acquire();
		System.out.println("philosopher :: " + philosopher + " :: has picked the right fork");
	}

	private void returnForks(int philosopher) throws InterruptedException {
		forks[(philosopher + 1) % 5].release();
		System.out.println("philosopher :: " + philosopher + " :: has returned the left fork");

		forks[philosopher].release();
		System.out.println("philosopher :: " + philosopher + " :: has returned the right fork");
	}
}
