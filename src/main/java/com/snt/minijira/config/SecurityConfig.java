package com.snt.minijira.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http    .formLogin().loginPage("/login")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").authenticated()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user").authenticated()
                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/");

    }
}
