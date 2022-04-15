package com.personal.learning.package1;

import com.personal.learning.package2.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class DataBaseService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }

    @Override
    public String getAnnotatedFortune() {
        return null;
    }
}
