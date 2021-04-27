package com.clickfit.centre.activity;

import java.util.ArrayList;
import java.util.List;

public abstract class Activity {

	List<ActivitySession> activitySessions;

	public Activity() {
		activitySessions = new ArrayList<>();
	}
}
