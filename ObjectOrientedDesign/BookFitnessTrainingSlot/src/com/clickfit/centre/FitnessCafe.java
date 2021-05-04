package com.clickfit.centre;

import com.clickfit.centre.activity.Activity;

public class FitnessCafe implements ClickFitCentre {
	private static FitnessCafe FitnessCafeCentre = null;
	
	private String centreName;

	private FitnessCafe() {
		centreName = CentreNameConstants.FITNESS_CAFE;
	}

	public FitnessCafe getCentreInstance() {
		if (FitnessCafeCentre == null) {
			FitnessCafeCentre = new FitnessCafe();
		}
		return FitnessCafeCentre;
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
