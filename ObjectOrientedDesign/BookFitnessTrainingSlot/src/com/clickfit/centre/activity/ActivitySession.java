package com.clickfit.centre.activity;

public class ActivitySession {
	int numberOfTotalSlots;
	int numberOfAvailableSlots;
	int startTime;
	int endTime;

	ActivitySession(int numberOfTotalSlots, int numberOfAvailableSlots, int startTime, int endTime) {
		this.numberOfTotalSlots = numberOfTotalSlots;
		this.numberOfTotalSlots = numberOfTotalSlots;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public void bookSession() {
		this.numberOfAvailableSlots--;
	}
}