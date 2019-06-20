package com.poe.ladder.backend.leaderboard.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@Builder
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
	
	@Column(name="timeStamp")
	private String timeStamp;
	
}
