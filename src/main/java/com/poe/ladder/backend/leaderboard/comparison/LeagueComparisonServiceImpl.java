package com.poe.ladder.backend.leaderboard.comparison;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

@Service
public class LeagueComparisonServiceImpl implements LeagueComparisonService {
	
	private final static Logger LOG = LoggerFactory.getLogger(LeagueComparisonServiceImpl.class);
	
	public List<LeaderBoardEntry> compareLeague(List<LeaderBoardEntry> oldLeagueData, List<LeaderBoardEntry> newLeagueData) {
		LOG.info("compareLeague called : attempting to compare league data to determine rank differences for league : {} - {}", newLeagueData.get(0).getLeague(), newLeagueData.get(0).getLeaderboard());
		List<LeaderBoardEntry> comparedLeagueList = new ArrayList<>();
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
	
	private String calcXpDifference(LeaderBoardEntry oldXp, LeaderBoardEntry newXp) {
		String oldXpAsString = removeCommasFromXpValue(oldXp.getExperience());
		String newXpAsString = removeCommasFromXpValue(newXp.getExperience());
		return performCalculation(oldXpAsString, newXpAsString);		
	}
	
	private String calcRankDifference(LeaderBoardEntry oldEntry, LeaderBoardEntry newEntry) {
		return performCalculation(newEntry.getRank(), oldEntry.getRank());
	}	
	
	private String performCalculation(String oldValue, String newValue) {
		Long oldValueAsLong = Long.parseLong(oldValue);
		Long newValueAsLong = Long.parseLong(newValue);
		Long difference = newValueAsLong - oldValueAsLong;		
		return difference.toString();
	}
	
	private String removeCommasFromXpValue(String aString) {
		return aString.replaceAll(",", "");
	}
	
}
	