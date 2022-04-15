package com.personal.learning.package2;

import com.personal.learning.package2.Coach;
import com.personal.learning.package2.FortuneService;

public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("no-arg constructor: inside cricket-coach");
    }
    private FortuneService fortuneService;
    private String email;
    private String team;

    @Override
    public String getDailyWorkout() {
        return "get into batting practice now";
    }

    @Override
    public String getDailyFortune() {
        return "go make a century";
    }

    public CricketCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("inside setter method, setFortuneService.");
        this.fortuneService = fortuneService;
    }

    public void setEmail(String email) {
        System.out.println("inside setter method, setEmail.");
        this.email = email;
    }

    public void setTeam(String team) {
        System.out.println("inside setter method, setTeam.");
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
