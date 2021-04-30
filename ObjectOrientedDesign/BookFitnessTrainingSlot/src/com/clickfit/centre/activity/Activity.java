package com.clickfit.centre.activity;

import java.util.ArrayList;
import java.util.List;

public abstract class Activity {

	protected List<ActivitySession> activitySessions;
	protected int activityId;

	public Activity() {
		activitySessions = new ArrayList<>();
		activityId++;
	}
	
	public List<ActivitySession> getActivitySessions() {
		return activitySessions;		
	}
}
