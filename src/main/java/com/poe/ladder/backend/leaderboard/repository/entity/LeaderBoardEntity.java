package com.poe.ladder.backend.leaderboard.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)	
public class LeaderBoardEntity {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
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

	@Column(name="characterName")
	private String character;
	
	@Column(name="ascendancy")
	private String ascendancy;
	
	@Column(name="time")
	private String time;
	
	@Column(name="time_difference")
	private String timeDifference;
	
	@Column(name="time_formatted")
	private String timeFormatted;
	
	@Column(name="depth")
	private String depth;
	
	@Column(name="depth_difference")
	private String depthDifference;
	
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
	
	public LeaderBoardEntity(Long id, String characterId, String rank, String rankDifference, String account,
			String online, String dead, String character, String ascendancy, String time, String timeDifference,
			String timeFormatted, String depth, String depthDifference, String level, String experience,
			String experienceDifference, String progress, String league, String leaderboard) {
		super();
		this.id = id;
		this.characterId = characterId;
		this.rank = rank;
		this.rankDifference = "0";
		this.account = account;
		this.online = online;
		this.dead = dead;
		this.character = character;
		this.ascendancy = ascendancy;
		this.time = time;
		this.timeDifference = timeDifference;
		this.timeFormatted = timeFormatted;
		this.depth = depth;
		this.depthDifference = depthDifference;
		this.level = level;
		this.experience = experience;
		this.experienceDifference = experienceDifference;
		this.progress = progress;
		this.league = league;
		this.leaderboard = leaderboard;
	}
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
	public String getTimeFormatted() {
		return timeFormatted;
	}
	public void setTimeFormatted(String timeInSeconds) {		
		Integer theTime = new Integer(timeInSeconds);
		int minutes = theTime/60;
		int seconds = theTime%60;
		this.timeFormatted = ""+minutes+"min "+seconds+"sec";
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
	public String getExperienceDifference() {
		return experienceDifference;
	}
	public void setExperienceDifference(String experienceDifference) {
		this.experienceDifference = experienceDifference;
	}
	public String getTimeDifference() {
		return timeDifference;
	}
	public void setTimeDifference(String timeDifference) {
		Integer theTime = new Integer(timeDifference);
		int minutes = theTime/60;
		int seconds = theTime%60;
		this.timeDifference = ""+minutes+"min "+seconds+"sec";
	}
	public String getDepthDifference() {
		return depthDifference;
	}
	public void setDepthDifference(String depthDifference) {
		this.depthDifference = depthDifference;
	}
	
	@Override
	public String toString() {
		return "LeaderBoardEntity [id=" + id + ", characterId=" + characterId + ", rank=" + rank + ", rankDifference="
				+ rankDifference + ", account=" + account + ", online=" + online + ", dead=" + dead + ", character="
				+ character + ", ascendancy=" + ascendancy + ", time=" + time + ", timeDifference=" + timeDifference
				+ ", depth=" + depth + ", depthDifference=" + depthDifference + ", level=" + level + ", experience="
				+ experience + ", experienceDifference=" + experienceDifference + ", progress=" + progress + ", league="
				+ league + ", leaderboard=" + leaderboard + "]";
	}	

}
