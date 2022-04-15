package com.personal.learning.package1;

import com.personal.learning.package2.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
        // retrieve bean from spring container
        Coach coach = context.getBean("swimmingCoach", Coach.class);
        coach.getDailyFortune();
        coach.getDailyWorkout();
        //
    }
}
