package com.revature;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@EnableCircuitBreaker
@RestController
@EnableEurekaClient
@SpringBootApplication
public class RestClientDemoApplication {
	public static void main(String[] args) {
		
		
		
	}

}
