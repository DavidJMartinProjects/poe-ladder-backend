package com.poe.ladder.backend.leaderboard.domain;

public class League {

	private String leagueName;

	public League(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getTheLeagueName() {
		return leagueName;
	}

	public void setTheLeagueName(String theLeagueName) {
		this.leagueName = theLeagueName;
	}
	
}
