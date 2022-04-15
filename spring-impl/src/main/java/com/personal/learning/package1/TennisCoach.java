package com.personal.learning.package1;
import org.springframework.stereotype.Component;

// this can be a default beanId too, and default beanId will be same as class name
// just first letter in lowercase
@Component("thatSillyTennisCoach")
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return "all the best with it";
    }
}
