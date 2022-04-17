package com.personal.learning.package4;

import com.personal.learning.package2.Coach;
import com.personal.learning.package2.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class ArcheryCoach implements Coach {
    private FortuneService fortuneService;
    @Value("${hihi.email}")
    private String email;
    @Value("${hihi.team}")
    private String team;

    public ArcheryCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "get into archery practice";
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyFortune() {
        fortuneService.getFortune();
        fortuneService.getAnnotatedFortune();
        return "äll the best with hand pain";
    }
}
