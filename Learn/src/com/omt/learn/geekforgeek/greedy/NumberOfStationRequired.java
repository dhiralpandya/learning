package com.omt.learn.geekforgeek.greedy;

import org.apache.commons.lang3.SystemUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NumberOfStationRequired {

    private static class Schedule {
        float arrivalTime = -1;
        float departureTime = -1;

        public Schedule(float at, float dt) {
            this.arrivalTime = at;
            this.departureTime = dt;
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

        System.out.println("Total Station Required :"+findMinStationRequired(allTrains));


    }



    private static int findMinStationRequired(List<Schedule> allTrains) {
        int totalStations = 1;

        Map<Float,Integer> timeArrivalDepartureMap = new TreeMap<>();


        for(Schedule schedule : allTrains) {
            if(!timeArrivalDepartureMap.containsKey(schedule.arrivalTime)){
               timeArrivalDepartureMap.put(schedule.arrivalTime,0);
            }

            if(!timeArrivalDepartureMap.containsKey(schedule.departureTime)) {
                timeArrivalDepartureMap.put(schedule.departureTime,0);
            }

            timeArrivalDepartureMap.put(schedule.arrivalTime,timeArrivalDepartureMap.get(schedule.arrivalTime)+1);
            timeArrivalDepartureMap.put(schedule.departureTime,timeArrivalDepartureMap.get(schedule.departureTime)-1);
        }

        int tempCount = 0;
        for (Float key : timeArrivalDepartureMap.keySet()) {
            tempCount+=timeArrivalDepartureMap.get(key);
            if(tempCount > totalStations) {
                totalStations = tempCount;
            }
        }

        return totalStations;
    }

}
