package com.clickfit.centre;

import java.util.List;

public interface ClickFitCentre {
	List<Activity> activityList = null;

	public default List<Activity> getAllWorkOuts() {
		return activityList;
	}

	public String getCentreName();

	public void addActivity(Activity activity);

}
