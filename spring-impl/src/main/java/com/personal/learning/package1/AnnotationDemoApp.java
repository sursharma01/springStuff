package com.personal.learning.package1;

import com.personal.learning.package2.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotation-applicationContext.xml");
        /*
        this is for tennisCoach
        // for picking an annotated class
        Coach tennisCoach = context.getBean("thatSillyTennisCoach", Coach.class);
        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(tennisCoach.getDailyFortune());
        */
        // for cricket coach
        Coach hockeyCoach = context.getBean("hockeyCoach", Coach.class);
        hockeyCoach.getDailyWorkout();
        hockeyCoach.getDailyFortune();
        context.close();
    }
}
