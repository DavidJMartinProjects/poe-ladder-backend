package com.poe.ladder.backend.leagues.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "leaderboard")
public class LeaderboardResultsLimitConfig {
	
	private int resultslimit;

	public int getResultslimit() {
		return resultslimit;
	}

	public void setResultslimit(int resultslimit) {
		this.resultslimit = resultslimit;
	}

}
