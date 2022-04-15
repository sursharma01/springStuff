package com.personal.learning.package1;

import com.personal.learning.package2.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ArcheryConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportsConfig.class);
        Coach coach = context.getBean("archeryCoach", Coach.class);
        ArcheryCoach archeryCoach = context.getBean("archeryCoach", ArcheryCoach.class);
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getDailyWorkout());
        System.out.println("email : "+archeryCoach.getEmail());
        System.out.println("team : "+archeryCoach.getTeam());

    }
}
