package com.poe.ladder.backend.leagues.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "activeleagues")
public class LeagueVariationsConfig {
	
	private Map<String, List<String>> leagueVariations;
	
	public Map<String, List<String>> getLeagueVariations() {
		return leagueVariations;
	}

	public void setLeagueVariations(Map<String, List<String>> leagueVariations) {
		this.leagueVariations = leagueVariations;
	}

}

	
