package com.clickfit.centre;

import com.clickfit.centre.activity.Activity;

public class WellnessCentre implements ClickFitCentre {
	private static WellnessCentre WellnessCentreCentre = null;

	private String centreName;

	private WellnessCentre() {
		centreName = CentreNameConstants.WELLNESS_CENTRE;
	}

	public WellnessCentre getCentreInstance() {
		if (WellnessCentreCentre == null) {
			WellnessCentreCentre = new WellnessCentre();
		}
		return WellnessCentreCentre;
	}

	@Override
	public String getCentreName() {
		// TODO Auto-generated method stub
		return centreName;
	}

	@Override
	public boolean addActivity(Activity activity) {
		// TODO Auto-generated method stub
		return this.activityList.add(activity);
	}

	@Override
	public boolean removeActivity(Activity activity) {
		// TODO Auto-generated method stub
		return this.activityList.remove(activity);
	}
	

}
