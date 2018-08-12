package com.omt.learn.geekforgeek.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfStationRequiredTwo {



    private static class Schedule implements  Comparable<Schedule>{
        float arrivalTime = -1;
        float departureTime = -1;

        public Schedule(float at, float dt) {
            this.arrivalTime = at;
            this.departureTime = dt;
        }


        /**
         * Below method to do sorting based on ArrivalTime
         * @param schedule
         * @return
         */
        @Override
        public int compareTo(Schedule schedule) {
            return (int)(this.arrivalTime - schedule.arrivalTime);
        }
    }

    public static void main(String args[]) {

        List<Schedule> allTrains = new ArrayList<>();
        allTrains.add(new Schedule(9.00f,9.10f));
        allTrains.add(new Schedule(15.00f,19.00f));
        allTrains.add(new Schedule(9.40f,12.00f));
        allTrains.add(new Schedule(11.00f,11.30f));
        allTrains.add(new Schedule(18.00f,20.10f));
        allTrains.add(new Schedule(9.50f,11.20f));

        System.out.println("Total Station Required :"+findMinStations(allTrains));


    }


    public static int findMinStations(List<Schedule>  allTrains) {
        int totalStations = 1;

        //Sort all Schedules with it's arrival time.
        Collections.sort(allTrains);

        int tempCount = 1;
        Schedule previousTrain = allTrains.get(0);
        for(int index = 1; index < allTrains.size(); index++){

            Schedule nextTrain = allTrains.get(index);
            if(previousTrain.departureTime < nextTrain.arrivalTime) {
                tempCount = 1; //RESET the temp Count
            } else {
                tempCount++;//We need one more station.
            }

            nextTrain.departureTime = Math.max(previousTrain.departureTime,nextTrain.departureTime);
            previousTrain = nextTrain;

            if(tempCount > totalStations) { // Calculate max stations
                totalStations = tempCount;
            }
        }



        return totalStations;
    }


}
