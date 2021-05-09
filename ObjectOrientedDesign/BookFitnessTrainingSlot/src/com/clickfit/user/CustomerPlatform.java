package com.clickfit.user;

import com.clickfit.centre.ClickFitCentre;
import com.clickfit.centre.activity.Activity;
import com.clickfit.centre.activity.ActivitySession;

public class CustomerPlatform extends Platform {
	
	private static CustomerPlatform customerPlatformInstance;
	
	private CustomerPlatform() {
		// TODO Auto-generated constructor stub
	}
	
	protected static CustomerPlatform getCustomerPlatformInstance () {
		if (customerPlatformInstance == null) {
			customerPlatformInstance = new CustomerPlatform();
		}
		return customerPlatformInstance;
	}
	
	public boolean registerOnPlatform(Customer cust) {
		return customers.add(cust);
	}
	
	public boolean deRegisterFromPlatform(Customer cust) {
		return customers.remove(cust);
	}
	
	public void viewActivitiesAcrossCentres () {
		for (ClickFitCentre centre: fitnessCentres) {
			System.out.println("In Centre "+centre.getCentreName()+", the following activites are available: ");
			viewActivititiesPerCentre(centre);
		}
	}
	
	public void viewActivitiesForCentre (ClickFitCentre centre) {
		System.out.println(centre.getCentreName()+" has the following sessions");
		viewActivititiesPerCentre(centre);
	}
	
	private void viewActivititiesPerCentre (ClickFitCentre centre) {
		for (Activity activity: centre.getAllActivities()) {
			System.out.println("\t "+activity.getActivityName()+" is available at");
			for (ActivitySession session : activity.getActivitySessions()) {
				System.out.println("\t \t "+session.getTimeSlot());
			}
		}
	}
	
	public void viewAllCentresForActivity (Activity act) {
		for (ClickFitCentre centre: fitnessCentres) {
			for (Activity activity: centre.getAllActivities()) {
				if (activity.getClass().equals(act.getClass())) {
					System.out.println("In Centre "+centre.getCentreName()+", the following activity sessions are available: ");
					for (ActivitySession session : activity.getActivitySessions()) {
						System.out.println("\t "+session.getTimeSlot());
					}
				}				
			}
		}
	}
	
	public boolean bookActivitySession (ClickFitCentre centre, Activity act, ActivitySession session) {
		return false;
	}
	
	

}
