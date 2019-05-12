package com.poe.ladder.backend.leaderboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LeaderBoardEntry {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="rank")
	private String rank; 
	
	@Column(name="character")
	private String character;
	
	@Column(name="ascendancy")
	private String ascendancy;
	
	@Column(name="time")
	private String time;
	
	@Column(name="depth")
	private String depth;
	
	@Column(name="level")
	private String level;
	
	@Column(name="league")
	private String league;
	
	@Column(name="leaderboard")
	private String leaderboard;
	
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getLeaderboard() {
		return leaderboard;
	}
	public void setLeaderboard(String leaderboard) {
		this.leaderboard = leaderboard;
	}
	@Override
	public String toString() {
		return "BaseEntry [id=" + id + ", rank=" + rank + ", character=" + character + ", ascendancy=" + ascendancy
				+ ", time=" + time + ", depth=" + depth + ", level=" + level + ", league=" + league + ", leaderboard="
				+ leaderboard + "]";
	}
	
}
