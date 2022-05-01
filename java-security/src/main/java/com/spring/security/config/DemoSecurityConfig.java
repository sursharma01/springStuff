package com.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
       UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        builder.inMemoryAuthentication()
                .withUser(userBuilder.username("jk").password("jk123").roles("Employee"))
                .withUser(userBuilder.username("rm").password("rm123").roles("Employee","Leader"))
                .withUser(userBuilder.username("bighit").password("bts123").roles("Admin"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/leaders/**").hasRole("Leader")
                .antMatchers("/").hasRole("Employee")
                .antMatchers("/systems/**").hasRole("Admin")
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }

}
