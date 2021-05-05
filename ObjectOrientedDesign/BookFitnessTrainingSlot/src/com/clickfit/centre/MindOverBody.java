package com.clickfit.centre;

import com.clickfit.centre.activity.Activity;

public class MindOverBody implements ClickFitCentre {
	private static MindOverBody MindOverCentre = null;

	private String centreName;

	private MindOverBody() {
		centreName = CentreNameConstants.MIND_OVER_BODY;
	}

	public MindOverBody getCentreInstance() {
		if (MindOverCentre == null) {
			MindOverCentre = new MindOverBody();
		}
		return MindOverCentre;
	}

	@Override
	public String getCentreName() {
		// TODO Auto-generated method stub
		return centreName;
	}

	@Override
	public boolean addActivity(Activity activity) {
		// TODO Auto-generated method stub
		return activityList.add(activity);
	}

	@Override
	public boolean removeActivity(Activity activity) {
		// TODO Auto-generated method stub
		return activityList.remove(activity);
	}
	
	@Override
	public boolean equals(Object obj) {
		ClickFitCentre centre = (ClickFitCentre) obj;
		return this.centreName.equalsIgnoreCase(centre.getCentreName());
	}
	
	@Override
	public int hashCode() {
		return 5 + 23*centreName.hashCode();
	}

}
