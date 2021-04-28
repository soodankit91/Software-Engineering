package com.clickfit.user;

import java.util.ArrayList;
import java.util.List;

import com.clickfit.centre.ClickFitCentre;

public class Platform {
	
	private List<ClickFitCentre> fitnessCentres;
	private List<Customer> customers;
	private static Platform clickFitPlatform = null;
	
	private Platform() {
		fitnessCentres = new ArrayList<>();
		customers = new ArrayList<>();
	}
	
	public Platform getPlatformInstance () {
		if (clickFitPlatform == null) {
			clickFitPlatform = new Platform();
		}
		return clickFitPlatform;
	}
	

}
