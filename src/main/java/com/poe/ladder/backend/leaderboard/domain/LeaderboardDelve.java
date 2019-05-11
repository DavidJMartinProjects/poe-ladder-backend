package com.poe.ladder.backend.leaderboard.domain;

public class LeaderboardDelve extends LeaderboardBase {
	
	private String depth;
		
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	
	@Override
	public String toString() {
		return "TopFiveDelve [depth=" + depth + "," + super.toString() + "]";
	}
	
}
