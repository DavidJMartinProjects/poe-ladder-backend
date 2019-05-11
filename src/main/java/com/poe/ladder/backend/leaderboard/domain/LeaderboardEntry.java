package com.poe.ladder.backend.leaderboard.domain;

public class LeaderboardEntry {
	
	private String rank; 
	private String character;
	private String ascendancy;
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getAscendancy() {
		return ascendancy;
	}
	public void setAscendancy(String ascendancy) {
		this.ascendancy = ascendancy;
	}
	
	@Override
	public String toString() {
		return "LeaderboardEntry [rank=" + rank + ", character=" + character + ", ascendancy=" + ascendancy + "]";
	}

}
