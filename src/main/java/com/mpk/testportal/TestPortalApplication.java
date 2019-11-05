package com.mpk.testportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class TestPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestPortalApplication.class, args);
	}
	
	@Bean
	Logger.Level getFeignLoggerLevel(){
		
		return Logger.Level.FULL;
	}
}
