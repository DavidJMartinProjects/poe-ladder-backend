package com.poe.ladder.backend.topfive.domain;

public class TopFiveBase {
	
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
		return "TopFiveBase [rank=" + rank + ", character=" + character + ", ascendancy=" + ascendancy + "]";
	}
	
}
