package com.omt.learn.algo.allAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityFinishTime {

	public static void main(String[] args) {
		ActivityFinishTime a = new ActivityFinishTime();
		Activity a1 = a.new Activity(1, 2);
		Activity a2 = a.new Activity(0, 6);
		Activity a3 = a.new Activity(5, 9);
		Activity a4 = a.new Activity(8, 9);
		Activity a5 = a.new Activity(5, 7);
		Activity a6 = a.new Activity(3, 4);

		List<Activity> listOfActivity = new ArrayList<>();
		listOfActivity.add(a1);
		listOfActivity.add(a2);
		listOfActivity.add(a3);
		listOfActivity.add(a4);
		listOfActivity.add(a5);
		listOfActivity.add(a6);

		for (Activity activity : findMaxActivityPerformBySinglePerson(listOfActivity)) {
			System.out.println(activity.getStartTime() + ":" + activity.getEndTime());
		}

	}

	public static List<Activity> findMaxActivityPerformBySinglePerson(List<Activity> listOfActivity) {
		Collections.sort(listOfActivity);

		List<Activity> selectedActivity = new ArrayList<>();
		selectedActivity.add(listOfActivity.get(0));

		Activity lastFinishedActivity = listOfActivity.get(0);

		for (int index = 1; index < listOfActivity.size(); index++) {
			if (listOfActivity.get(index).getStartTime() >= lastFinishedActivity.getEndTime()) {
				selectedActivity.add(listOfActivity.get(index));
				lastFinishedActivity = listOfActivity.get(index);
			}
		}

		return selectedActivity;
	}

	class Activity implements Comparable<Activity> {

		private int startTime;
		private int endTime;

		public Activity(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Activity o) {
			return endTime - o.getEndTime();
		}

	}

}
