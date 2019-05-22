package com.poe.ladder.backend.leagues.web;

import java.util.ArrayList;
import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

public class LeaderBoardEntryTestUtil {
	
	LeaderBoardEntry leaderBoardEntryOne = new LeaderBoardEntry();
	LeaderBoardEntry leaderBoardEntryTwo = new LeaderBoardEntry();
	LeaderBoardEntry leaderBoardEntryThree = new LeaderBoardEntry();	
		
	public LeaderBoardEntryTestUtil() {
		leaderBoardEntryOne.setAscendancy("Assassin");
		leaderBoardEntryOne.setCharacter("testCharacter");
		leaderBoardEntryOne.setDead("true");
		leaderBoardEntryOne.setExperience("1,000,000");
		leaderBoardEntryOne.setLeaderboard("Top Race To 100");
		leaderBoardEntryOne.setLeague("Synthesis");
		leaderBoardEntryOne.setLevel("90");	
		leaderBoardEntryOne.setOnline("true");
		leaderBoardEntryOne.setProgress("50.0");
		leaderBoardEntryOne.setRank("150");
		
		leaderBoardEntryOne.setAscendancy("Templar");
		leaderBoardEntryOne.setCharacter("testCharacter");
		leaderBoardEntryOne.setDead("true");
		leaderBoardEntryOne.setExperience("2,000,000");
		leaderBoardEntryOne.setLeaderboard("Top Delve Depths");
		leaderBoardEntryOne.setLeague("Synthesis");
		leaderBoardEntryOne.setLevel("85");
		leaderBoardEntryOne.setOnline("true");
		leaderBoardEntryOne.setProgress("55.0");
		leaderBoardEntryOne.setRank("250");
				
		leaderBoardEntryOne.setAscendancy("Gladiator");
		leaderBoardEntryOne.setCharacter("testCharacter");
		leaderBoardEntryOne.setDead("true");
		leaderBoardEntryOne.setExperience("3,000,000");
		leaderBoardEntryOne.setLeaderboard("Top Uberlab Times");
		leaderBoardEntryOne.setLeague("Synthesis");
		leaderBoardEntryOne.setLevel("80");
		leaderBoardEntryOne.setOnline("true");
		leaderBoardEntryOne.setProgress("60.0");
		leaderBoardEntryOne.setRank("350");
	}
	
	public List<LeaderBoardEntry> getLeaderboardEntries() {
		List<LeaderBoardEntry> leaderboardentries =  new ArrayList<>();	
		leaderboardentries.add(leaderBoardEntryOne);
		leaderboardentries.add(leaderBoardEntryTwo);
		leaderboardentries.add(leaderBoardEntryThree);	
		return leaderboardentries;
	}	

}
