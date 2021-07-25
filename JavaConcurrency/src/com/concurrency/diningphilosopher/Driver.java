package com.concurrency.diningphilosopher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int philosophersCount =initializeDiningTable(sc);
		List<Philosopher> philosophersList = initializePhilosophers(sc, philosophersCount);
		feedPhilosophers(philosophersList);
	}
	
	private static int initializeDiningTable(Scanner sc) {		
		System.out.println("How many philosophers are present at table?");
		int philosophersCount = sc.nextInt();
		return philosophersCount;
	}
	
	private static List<Philosopher> initializePhilosophers(Scanner sc, int philosophersCount) {
		DiningPhilosophers dp = new DiningPhilosophers(philosophersCount);
		List<Philosopher> list = new ArrayList<>();
		System.out.println("Enter default dining time for all philosophers");
		long diningTime = sc.nextLong();
		
		for (int i=0; i<philosophersCount; i++) {
			list.add(new Philosopher(i, dp, diningTime));
		}
		return list;
	}
	
	private static void feedPhilosophers(List<Philosopher> philosophersList) {
		for (Philosopher ph: philosophersList) {
			Thread t = new Thread(ph);
			t.start();
		}
	}
	
}
