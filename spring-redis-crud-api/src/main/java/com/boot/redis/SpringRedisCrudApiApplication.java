package com.boot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRedisCrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisCrudApiApplication.class, args);
	}

}
