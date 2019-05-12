package com.poe.ladder.backend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
	"com.poe.ladder.backend", 
	"com.poe.ladder.backend.leaderboard",	
	"com.poe.ladder.backend.external.api",
	"com.poe.ladder.backend.external.api.response"
})
@EnableJpaRepositories("com.poe.ladder.backend.leaderboard.dao")
@EntityScan("com.poe.ladder.backend.leaderboard.domain")	
public class PoeLadderBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoeLadderBackendApplication.class, args);
	}

}	
	