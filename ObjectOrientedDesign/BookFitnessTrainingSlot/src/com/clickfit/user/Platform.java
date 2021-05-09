package com.clickfit.user;

import java.util.ArrayList;
import java.util.List;

import com.clickfit.centre.ClickFitCentre;

public abstract class Platform {

	protected List<ClickFitCentre> fitnessCentres;
	protected List<Customer> customers;

	protected Platform() {
		fitnessCentres = new ArrayList<>();
		customers = new ArrayList<>();
	}
}
