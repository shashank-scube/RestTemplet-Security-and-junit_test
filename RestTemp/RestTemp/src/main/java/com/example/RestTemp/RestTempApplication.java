package com.example.RestTemp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTempApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTempApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplet() {
		return new RestTemplate();
	}
}
