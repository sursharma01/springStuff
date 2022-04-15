package com.personal.learning.package2;

public class TrackCoach implements Coach{
    public TrackCoach(){

    }
    private FortuneService fortuneService;
    public TrackCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "get on track fast";
    }

    @Override
    public String getDailyFortune() {
        return "track-coach says :"+fortuneService.getFortune();
    }
}
