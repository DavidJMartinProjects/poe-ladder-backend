package com.poe.ladder.backend.leagues.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "leagues")
public class LeagueNamesConfig {
	
	private List<String> currentLeagues;

	public List<String> getCurrentLeagues() {
		return currentLeagues;
	}

	public void setCurrentLeagues(List<String> currentLeagues) {
		this.currentLeagues = currentLeagues;
	}

}	
