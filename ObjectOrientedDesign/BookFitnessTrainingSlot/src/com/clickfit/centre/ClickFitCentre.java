package com.clickfit.centre;

import java.util.ArrayList;
import java.util.List;

import com.clickfit.centre.activity.Activity;
import com.clickfit.centre.activity.Cardio;
import com.clickfit.centre.activity.Swimming;
import com.clickfit.centre.activity.Weights;
import com.clickfit.centre.activity.Yoga;


public interface ClickFitCentre {
	List<Activity> activityList = null;

	public default List<Activity> getAllWorkOuts() {
		return activityList;
	}

	public String getCentreName();

	public void addActivity(Activity activity);
	
	public default List<Yoga> getYogaSessions() {
		List<Yoga> yogaSessions = new ArrayList<>();
		for (Activity act : this.activityList) {
			if (act instanceof Yoga ) {
				yogaSessions.add((Yoga) act);
			}
		}
		return yogaSessions;
	}

	
	public default List<Cardio> getCardioSessions() {
		
		List<Cardio> cardioSessions = new ArrayList<>();
		for (Activity act : this.activityList) {
			if (act instanceof Cardio ) {
				cardioSessions.add((Cardio) act);
			}
		}
		return cardioSessions;
	}

	
	public default List<Weights> getWeightSessions() {
		List<Weights> weigthsSessions = new ArrayList<>();
		for (Activity act : this.activityList) {
			if (act instanceof Weights ) {
				weigthsSessions.add((Weights) act);
			}
		}
		return weigthsSessions;
	}
	
	public default List<Swimming> getSwimmingSessions() {
		List<Swimming> swimmingSessions = new ArrayList<>();
		for (Activity act : this.activityList) {
			if (act instanceof Swimming ) {
				swimmingSessions.add((Swimming) act);
			}
		}
		return swimmingSessions;
	}

}
