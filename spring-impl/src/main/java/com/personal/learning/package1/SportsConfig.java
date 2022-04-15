package com.personal.learning.package1;

import com.personal.learning.package2.Coach;
import com.personal.learning.package2.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.personal.learning.package1")
@PropertySource("classpath:info.properties")
public class SportsConfig {
        // define bean for sad fortune service
        @Bean
        public FortuneService sadFortuneService(){
            return new SadFortuneService();
        }

        // define bean for swim coach and inject dependency
        @Bean
        public Coach archeryCoach(){
            return new ArcheryCoach(sadFortuneService());
        }

    }

