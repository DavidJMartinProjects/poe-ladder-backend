package com.poe.ladder.backend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@ComponentScan(basePackages = { 
	"com.poe.ladder.backend", 
	"com.poe.ladder.backend.leaderboard",
	"com.poe.ladder.backend.external.api", 
	"com.poe.ladder.backend.external.api.response",	
	"com.poe.ladder.backend.leaderboard.repository"
})
@EnableJpaRepositories("com.poe.ladder.backend.leaderboard.repository")
@EntityScan("com.poe.ladder.backend.leaderboard.domain")
public class PoeLadderBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoeLadderBackendApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
