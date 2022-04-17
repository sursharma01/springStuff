package com.personal.learning.package4;

import com.personal.learning.package2.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context  =
                new AnnotationConfigApplicationContext(SportsConfig.class);
        Coach coach = context.getBean("archeryCoach", Coach.class);
        coach.getDailyWorkout();
        coach.getDailyFortune();
    }
}
