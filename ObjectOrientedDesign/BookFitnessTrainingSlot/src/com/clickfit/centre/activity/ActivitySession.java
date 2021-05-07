package com.clickfit.centre.activity;

public class ActivitySession {
	int numberOfTotalSlots;
	int numberOfAvailableSlots;
	int startTime;
	int endTime;
	int activityId;

	ActivitySession(int numberOfTotalSlots, int numberOfAvailableSlots, int startTime, int endTime, int activityId) {
		this.numberOfTotalSlots = numberOfTotalSlots;
		this.numberOfTotalSlots = numberOfTotalSlots;
		this.startTime = startTime;
		this.endTime = endTime;
		this.activityId = activityId;
	}
	
	public void bookSession() {
		this.numberOfAvailableSlots--;
	}
	
	public String getTimeSlot() {
		return "starts at: "+Integer.toString(startTime)+" ends at: "+Integer.toString(endTime);
	}
	
	boolean updateSession (int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		return true;
	}
	
	public boolean equals(Object obj) {
		ActivitySession session = (ActivitySession) obj;
		return this.activityId == session.activityId && this.startTime == session.startTime && this.endTime == session.endTime;
	}
}