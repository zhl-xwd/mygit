package com.cs.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan("com.cs.web.dao")
@EnableTransactionManagement
@EnableCaching
@EnableAsync
public class Application {

	
	public static void main(String[] args) {
		
		System.out.println("测试1111111");
		SpringApplication.run(Application.class, args);

	}
}