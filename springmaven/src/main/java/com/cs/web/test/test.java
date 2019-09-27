package com.cs.web.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-lnh.properties")
public class test {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public void show(){
        System.out.println("a --- > " + url);
        System.out.println("b --- > " + username);
        System.out.println("c --- > " + password);
    }
}
