package com.personal.learning.package2;

public class BaseballCoach implements Coach{
    public BaseballCoach(){

    }
    //define a private field for dependency
    private FortuneService fortuneService;
    //define a constructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "get into warm-up for 30 min";
    }

    @Override
    public String getDailyFortune() {
        //myfortune service to give fortune
        return fortuneService.getFortune();
    }
    //add an init-method
    public void doMyStartUpStuff(){
        System.out.println("inside init-method i.e doMyStartUpStuff method");
    }
    //add a destroy method
    public void cleanMyStartUpStuff(){
        System.out.println("inside destroy method i.e. cleanStartUpStuff method");
    }
}
