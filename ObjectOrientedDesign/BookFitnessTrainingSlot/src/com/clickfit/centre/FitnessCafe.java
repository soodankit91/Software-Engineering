package com.clickfit.centre;

public class FitnessCafe implements ClickFitCentre {
	public static FitnessCafe FitnessCafeCentre = null;
	
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
	public void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		this.activityList.add(activity);
	}
}
