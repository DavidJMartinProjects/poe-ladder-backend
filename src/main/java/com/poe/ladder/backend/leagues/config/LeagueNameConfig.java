package com.poe.ladder.backend.leagues.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "leagues")
public class LeagueNameConfig {
	
	@PostConstruct
	public void printList() {
		currentLeagues.forEach(e -> System.out.println(e));
	}

	private List<String> currentLeagues;

	public List<String> getCurrentLeagues() {
		return currentLeagues;
	}

	public void setCurrentLeagues(List<String> currentLeagues) {
		this.currentLeagues = currentLeagues;
	}

}
