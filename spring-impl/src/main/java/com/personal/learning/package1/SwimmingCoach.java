package com.personal.learning.package1;

import com.personal.learning.package2.Coach;
import com.personal.learning.package2.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SwimmingCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Autowired
    public SwimmingCoach(){
        System.out.println("ïnside swimming coach default constructor");
    }
    // define init method
    @PostConstruct
    public void doMyPostConstructStuff(){
        System.out.println("ïnside post construct annotated method");
    }

    @PreDestroy
    public void doMyPreDestroyStuff(){
        System.out.println("ïnside pre destroy annotated method");
    }
    @Override
    public String getDailyFortune() {
        return null;
    }

    @Override
    public String getDailyWorkout() {
        return null;
    }
}
