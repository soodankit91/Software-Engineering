package com.clickfit.user;

public class Customer {

	private String name;
	private int id;

	public Customer(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		Customer person = (Customer) obj;
		return this.id == person.id;
	}
}
