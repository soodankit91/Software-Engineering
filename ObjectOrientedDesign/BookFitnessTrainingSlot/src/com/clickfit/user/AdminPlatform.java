package com.clickfit.user;

import com.clickfit.centre.ClickFitCentre;
import com.clickfit.centre.activity.Activity;
import com.clickfit.centre.activity.ActivitySession;

public class AdminPlatform extends Platform {

	private static AdminPlatform adminPlatformInstance;

	private AdminPlatform() {
		super();
	}

	protected static AdminPlatform getAdminPlatformInstance() {
		if (adminPlatformInstance == null) {
			adminPlatformInstance = new AdminPlatform();
		}
		return adminPlatformInstance;
	}

	boolean registerCentre(ClickFitCentre centre) {
		return fitnessCentres.add(centre);
	}

	boolean deRegisterCentre(ClickFitCentre centre) {
		return fitnessCentres.remove(centre);
	}

	boolean addActivity(ClickFitCentre centre, Activity activity) {
		return centre.addActivity(activity);
	}

	boolean removeActivity(ClickFitCentre centre, Activity activity) {
		return centre.removeActivity(activity);
	}

	boolean addActivitySession(ClickFitCentre centre, Activity activity, ActivitySession session) {
		for (Activity act : centre.getAllActivities()) {
			if (activity.equals(act)) {
				return activity.addActivitySession(session);
			}
		}
		return false;
	}

	boolean removeActivitySession(ClickFitCentre centre, Activity activity, ActivitySession session) {
		for (Activity act : centre.getAllActivities()) {
			if (activity.equals(act)) {
				return activity.removeActivitySession(session);
			}
		}
		return false;
	}

	boolean updateActivitySession(ClickFitCentre centre, Activity activity, ActivitySession session, int startTime,
			int endTime) {
		for (Activity act : centre.getAllActivities()) {
			if (activity.equals(act)) {
				return activity.updateActivitySession(session, startTime, endTime);
			}
		}
		return false;
	}

}
