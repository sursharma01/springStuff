package com.personal.learning.package2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve beans from spring container
        Coach coach = context.getBean("myCoach", Coach.class);
        //call methods on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        //setter demo methods
        //load spring config file
        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
        //retrieve bean from spring container
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getDailyWorkout());
        //call methods on bean
        System.out.println(cricketCoach.getEmail());
        System.out.println(cricketCoach.getTeam());
        //close the context
        context.close();
    }
}
