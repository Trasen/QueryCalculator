package com.harnosandesport.querycalculator.Services.Spring;

import com.harnosandesport.querycalculator.Services.StartService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring implements StartService {
	public void run(String[] args) {
		SpringApplication.run(Spring.class, args);
	}
}