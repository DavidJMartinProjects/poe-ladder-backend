package com.poe.ladder.backend.leaderboard.comparison;

import java.util.ArrayList;
import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

public class LeagueComparisonServiceImpl implements LeagueComparisonService {
	
	private List<LeaderBoardEntry> comparedLeagueList;
	
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
		LeaderBoardEntry comparedleagueEntry = newLeagueDataEntry;		
		comparedleagueEntry.setRankDifference(calcRankDifference(oldLeagueDataEntry, newLeagueDataEntry));
		comparedleagueEntry.setExperienceDifference(calcXpDifference(oldLeagueDataEntry, newLeagueDataEntry));
		return comparedleagueEntry;
	}

	private String calcRankDifference(LeaderBoardEntry oldRank, LeaderBoardEntry newRank) {
		return calculateDifference(oldRank.getExperience(), newRank.getExperience());
	}	
	
	private String calcXpDifference(LeaderBoardEntry oldXp, LeaderBoardEntry newXp) {
		String oldXpAsString = removeCommasFromXpValue(oldXp.getExperience());
		String newXpAsString = removeCommasFromXpValue(newXp.getExperience());
		return calculateDifference(oldXpAsString, newXpAsString);
	}
	
	private String calculateDifference(String oldValue, String newValue) {
		Double oldValueAsDouble = new Double(oldValue);
		Double newValueAsDouble = new Double(newValue);
		Double difference = oldValueAsDouble - newValueAsDouble;
		return difference.toString();
	}
	
	private String removeCommasFromXpValue(String aString) {
		return aString.replaceAll(",", "");
	}
	
}
	