package com.poe.ladder.backend.leaderboard.comparison;

import java.util.ArrayList;
import java.util.List;

import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

public class LeagueComparisonServiceImpl implements LeagueComparisonService {
	
	private List<LeaderBoardEntry> comparedLeagueList;
	private LeaderBoardEntry comparedleagueEntry;
	
	public List<LeaderBoardEntry> compareLeague(List<LeaderBoardEntry> oldLeagueData, List<LeaderBoardEntry> newLeagueData) {
		for (LeaderBoardEntry newLeagueDataEntry : newLeagueData) {
			for (LeaderBoardEntry oldLeagueDataEntry : oldLeagueData) {
				comparedLeagueList = new ArrayList<>(newLeagueData);
				if(newLeagueDataEntry.getCharacterId().equals(oldLeagueDataEntry.getCharacterId())) {
					comparedLeagueList.add(performComparison(oldLeagueDataEntry, newLeagueDataEntry));
				} else {
					comparedLeagueList.add(newLeagueDataEntry);
				}
			}				
		}			
		return comparedLeagueList;		
	}
	
	private LeaderBoardEntry performComparison(LeaderBoardEntry oldLeagueDataEntry, LeaderBoardEntry newLeagueDataEntry) {
		comparedleagueEntry = newLeagueDataEntry;		
		comparedleagueEntry.setRank(compareRank(oldLeagueDataEntry, newLeagueDataEntry));
		comparedleagueEntry.setExperience(compareXp(oldLeagueDataEntry, newLeagueDataEntry));
		return comparedleagueEntry;
	}

	private String compareRank(LeaderBoardEntry oldRank, LeaderBoardEntry newRank) {
		return null;
	}	
	
	private String compareXp(LeaderBoardEntry oldRank, LeaderBoardEntry newRank) {
		return null;
	}
	
	private String compareValues(String oldValue, String newValue) {
		return null;
	}
	
}
	