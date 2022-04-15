package com.personal.learning.package2;

import com.personal.learning.package2.BaseballCoach;
import com.personal.learning.package2.Coach;
import com.personal.learning.package2.TrackCoach;

public class MyApp {
    public static void main(String[] args) {
        // hard coded object creation
        Coach coach = new BaseballCoach();
        System.out.println("about baseball coach : "+coach.getDailyWorkout());

        coach = new TrackCoach();
        System.out.println("about track-coach : "+coach.getDailyWorkout());

        // spring inversion of control

    }
}
