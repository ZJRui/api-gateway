package com.sachin.aipgateway;

import com.sachin.aipgateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class AipGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AipGatewayApplication.class, args);
	}


	/*@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}*/



}
