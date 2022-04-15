package com.personal.learning.package1;


public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "today is ur lucky day";
    }

    @Override
    public String getAnnotatedFortune() {
        return "have a great annotated day ;) ";
    }
}
