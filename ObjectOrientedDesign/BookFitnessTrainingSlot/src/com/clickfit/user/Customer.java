package com.clickfit.user;

public class Customer {

	private String name;
	private int id;
	private static int counter = 0;

	public Customer(String name) {
		this.name = name;
		this.id = ++counter;
	}

	@Override
	public boolean equals(Object obj) {
		Customer person = (Customer) obj;
		return this.id == person.id;
	}
	
	@Override
	public int hashCode() {
		return 53 * this.id;
	}
}
