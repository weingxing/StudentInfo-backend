package com.oxygen.studentinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConﬁg extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http){
        try {
            http.headers().frameOptions().disable();

            http.authorizeRequests()
                    .antMatchers("/mini/**",
                            "/favicon.ico",
                            "/layui/**",
                            "/css/**",
                            "/js/**",
                            "/images/**",
                            "/login")
                    .permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .successForwardUrl("/login?status=successful")
                    .failureForwardUrl("/login?status=error")
                    .and()
                    .logout()
                    .permitAll()
                    .and()
                    .csrf()
                    .disable();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
