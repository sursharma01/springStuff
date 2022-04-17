package com.personal.learning.package1;

import com.personal.learning.package2.FortuneService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // create an array of strings
    private final String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    // create a random number generator
    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        // pick a random string from the array
        int index = myRandom.nextInt(data.length);

        return data[index];
    }

    @Override
    public String getAnnotatedFortune() {
        return "get annotated fortune from RandomFortuneService";
    }

}
