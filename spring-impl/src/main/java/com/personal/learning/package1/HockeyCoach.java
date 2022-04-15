package com.personal.learning.package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("hockeyCoach")
public class HockeyCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Autowired
    public HockeyCoach(){
        System.out.println("ïnside hockey coach default constructor");
    }

//    @Autowired
//    public HockeyCoach(FortuneService theFortuneService){
//        fortuneService = theFortuneService;
//    }
//
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println("inside setFortune method");
//        this.fortuneService = fortuneService;
//    }

    @Autowired
    public void doCrazyStuff(FortuneService fortuneService) {
        System.out.println("inside doCrazyStuff method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "get into hockey field";
    }

    @Override
    public String getDailyFortune() {
        fortuneService.getFortune();
        fortuneService.getAnnotatedFortune();
        return "good luck with the stick";
    }
}
