package com.personal.learning.package4;

import com.personal.learning.package2.FortuneService;

public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "today  can be a sad day";
    }

    @Override
    public String getAnnotatedFortune() {
        return "today can be a sad annotated day";
    }
}
