package com.poe.ladder.backend.leaderboard.domain;

public class UberLabLeaderboardEntry extends LeaderboardEntry {
	
	String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TopFiveUberLab [time=" + time + "," + super.toString() + "]";
	}
	
}
