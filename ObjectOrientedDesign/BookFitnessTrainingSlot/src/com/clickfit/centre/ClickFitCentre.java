package com.clickfit.centre;

import java.util.ArrayList;
import java.util.List;

import com.clickfit.centre.activity.Activity;
import com.clickfit.centre.activity.ActivitySession;
import com.clickfit.centre.activity.Cardio;
import com.clickfit.centre.activity.Swimming;
import com.clickfit.centre.activity.Weights;
import com.clickfit.centre.activity.Yoga;

public interface ClickFitCentre {
	List<Activity> activityList = null;

	public String getCentreName();

	public boolean addActivity(Activity activity);
	
	public boolean removeActivity(Activity activity);

	public default List<Activity> getAllActivities() {
		return activityList;
	}

	public default List<ActivitySession> getYogaSessions() {
		List<ActivitySession> yogaSessions = new ArrayList<>();
		for (Activity act : activityList) {
			if (act instanceof Yoga) {
				yogaSessions.addAll(act.getActivitySessions());
			}
		}
		return yogaSessions;
	}

	public default List<ActivitySession> getCardioSessions() {
		List<ActivitySession> cardioSessions = new ArrayList<>();
		for (Activity act : activityList) {
			if (act instanceof Cardio) {
				cardioSessions.addAll(act.getActivitySessions());
			}
		}
		return cardioSessions;
	}

	public default List<ActivitySession> getWeightSessions() {
		List<ActivitySession> weigthsSessions = new ArrayList<>();
		for (Activity act : activityList) {
			if (act instanceof Weights) {
				weigthsSessions.addAll(act.getActivitySessions());
			}
		}
		return weigthsSessions;
	}

	public default List<ActivitySession> getSwimmingSessions() {
		List<ActivitySession> swimmingSessions = new ArrayList<>();
		for (Activity act : activityList) {
			if (act instanceof Swimming) {
				swimmingSessions.addAll(act.getActivitySessions());
			}
		}
		return swimmingSessions;
	}

}
