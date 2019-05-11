package com.poe.ladder.backend.topfive.domain;

public class TopFiveDelve {
	
	private String rank; 
	private String character;
	private String ascendancy;
	private String depth;
	
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
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "TopFiveDelve [rank=" + rank + ", character=" + character + ", ascendancy=" + ascendancy + ", depth=" + depth + "]";
	}
	
}
