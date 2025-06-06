package com.restapi.allannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

//Refer notes for EnableAysnc. 

@SpringBootApplication
@EnableAsync
public class AllannotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllannotationsApplication.class, args);
	}

}
