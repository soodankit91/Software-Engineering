package com.clickfit.centre;

import com.clickfit.centre.activity.Activity;

public class WellnessCentre implements ClickFitCentre {
	public static WellnessCentre WellnessCentreCentre = null;

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
	public void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		this.addActivity(activity);
	}

}
