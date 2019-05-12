package com.poe.ladder.backend.leaderboard.domain;

public enum LeaderboardType {
	
	DELVE("Top Delve Depths"),
	UBERLAB("Top UberLab Times"), 
	RACETO100("Top Race to 100"),
	UNKNOWN("Unknown Leaderboard");	
	
	private String value;

	LeaderboardType(final String value) {
        this.value = value;
    }
	
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
    
}
