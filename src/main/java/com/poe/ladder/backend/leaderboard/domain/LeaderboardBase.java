package com.poe.ladder.backend.leaderboard.domain;

public class LeaderboardBase {
	
	private String rank; 
	private String character;
	private String ascendancy;
	private String leagueName;
	
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
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	@Override
	public String toString() {
		return "LeaderboardBase [rank=" + rank + ", character=" + character + ", ascendancy=" + ascendancy + ", leagueName=" + leagueName + "]";
	}
	
}
