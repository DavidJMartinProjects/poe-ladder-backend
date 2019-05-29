package com.poe.ladder.backend.leaderboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)	
public class LeaderBoardEntry {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="char_id")
	private String characterId; 
	
	@Column(name="rank")
	private String rank; 
	
	@Column(name="rank_difference")
	private String rankDifference; 
	
	@Column(name="account")
	private String account;

	@Column(name="online")
	private String online;

	@Column(name="dead")
	private String dead;

	@Column(name="character")
	private String character;
	
	@Column(name="ascendancy")
	private String ascendancy;
	
	@Column(name="time")
	private String time;
	
	@Column(name="depth")
	private Integer depth;
	
	@Column(name="depth_difference")
	private Integer depthDifference;
	
	@Column(name="level")
	private String level;
	
	@Column(name="xp")
	private String experience;
	
	@Column(name="xp_difference")
	private String experienceDifference;
	
	@Column(name="progress")
	private String progress;
	
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
		Integer theTime = new Integer(time);
		int minutes = theTime/60;
		int seconds = theTime%60;
		this.time = ""+minutes+"min "+seconds+"sec";
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}

	public String getDead() {
		return dead;
	}
	public void setDead(String dead) {
		this.dead = dead;
	}
	public String getCharacterId() {
		return characterId;
	}
	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}
	public String getRankDifference() {
		return rankDifference;
	}
	public void setRankDifference(String rankDifference) {
		this.rankDifference = rankDifference;
	}
	public Integer getDepthDifference() {
		return depthDifference;
	}
	public void setDepthDifference(Integer depthDifference) {
		this.depthDifference = depthDifference;
	}
	public String getExperienceDifference() {
		return experienceDifference;
	}
	public void setExperienceDifference(String experienceDifference) {
		this.experienceDifference = experienceDifference;
	}
	
	@Override
	public String toString() {
		return "LeaderBoardEntry [id=" + id + ", characterId=" + characterId + ", rank=" + rank + ", rankDifference="
				+ rankDifference + ", account=" + account + ", online=" + online + ", dead=" + dead + ", character="
				+ character + ", ascendancy=" + ascendancy + ", time=" + time + ", depth=" + depth
				+ ", depthDifference=" + depthDifference + ", level=" + level + ", experience=" + experience
				+ ", experienceDifference=" + experienceDifference + ", progress=" + progress + ", league=" + league
				+ ", leaderboard=" + leaderboard + "]";
	}

}
