package com.clickfit.centre.activity;

import java.util.ArrayList;
import java.util.List;

public abstract class Activity {

	protected List<ActivitySession> activitySessions;
	protected int activityId;
	protected String activityName;

	public Activity() {
		activitySessions = new ArrayList<>();
		activityId++;
	}
	
	public List<ActivitySession> getActivitySessions() {
		return activitySessions;		
	}
	
	public boolean addActivitySession(ActivitySession session) {
		return this.activitySessions.add(session);
	}
	
	public boolean removeActivitySession(ActivitySession session) {
		return this.activitySessions.remove(session);
	}
	
	public boolean updateActivitySession(ActivitySession session, int startTime, int endTime) {
		for (ActivitySession actSess : activitySessions) {
			if (actSess.equals(session)) {
				session.updateSession(startTime, endTime);
			}
		}
		return true;
	}
	
	public int getActivityId() {
		return activityId;
	}
	
	public String getActivityName() {
		return activityName;
	}
	
	@Override
	public boolean equals (Object obj) {
		Activity act = (Activity) obj;
		return this.activityId == act.activityId;
	}	
	
	@Override
	public int hashCode() {
		return 89 * this.activityId;
	}
}
