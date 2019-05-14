package com.poe.ladder.backend.leagues.config;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "leagues")
public class LeagueNamesConfig {
	
	private List<String> currentLeagues;
	private List<String> leagueNames;

	public List<String> getCurrentLeagues() {
		return currentLeagues;
	}

	public void setCurrentLeagues(List<String> currentLeagues) {
		this.currentLeagues = currentLeagues;
	}

	public List<String> getLeagueNames() {
		return leagueNames;
	}

	public void setLeagueNames(List<String> leagueNames) {
		this.leagueNames = leagueNames;
	}

}	
