package com.poe.ladder.backend.leaderboard.domain;

public class RaceLeaderboardEntry extends LeaderboardEntry {
	
	String level;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "TopFiveRace [level=" + level + "," + super.toString() + "]";
	}

}
