package com.oxygen.studentinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * SpringSecurity配置类，控制访问权限、设置密码编码器
 */
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
                            "/login")  // 无需登录，可以直接访问
                    .permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")  // 指定登录页面
                    .permitAll()
                    .successForwardUrl("/login?status=successful") // 登陆成功跳转
                    .failureForwardUrl("/login?status=error")  // 登陆失败跳转
                    .and()
                    .logout()
                    .permitAll()
                    .and()
                    .csrf()
                    .disable();  // 关闭跨域
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
