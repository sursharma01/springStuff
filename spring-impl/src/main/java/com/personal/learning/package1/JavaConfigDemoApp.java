package com.personal.learning.package1;

import com.personal.learning.package2.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context  =
                new AnnotationConfigApplicationContext(SportsConfig.class);
        Coach coach = context.getBean("swimmingCoach", Coach.class);
        coach.getDailyWorkout();
        coach.getDailyFortune();
    }
}
