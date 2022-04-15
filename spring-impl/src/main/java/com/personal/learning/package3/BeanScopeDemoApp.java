package com.personal.learning.package3;

import com.personal.learning.package2.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //retrieve bean from container
        Coach coach = context.getBean("myCoach", Coach.class);
        Coach theCoach = context.getBean("myCoach", Coach.class);
        // scope can be singleton(bydefault), prototype and others
        boolean result = (coach == theCoach);
        System.out.println("are they pointing to same object : "+result);
        System.out.println("memory location of coach object : "+coach);
        System.out.println("memory location of theCoach object : "+theCoach);
        //close the context
        context.close();
    }
}
