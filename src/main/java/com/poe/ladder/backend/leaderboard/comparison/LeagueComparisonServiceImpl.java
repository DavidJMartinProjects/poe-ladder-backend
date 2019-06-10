package com.poe.ladder.backend.leaderboard.comparison;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

@Service
public class LeagueComparisonServiceImpl implements LeagueComparisonService {
	
	private final static Logger LOG = LoggerFactory.getLogger(LeagueComparisonServiceImpl.class);
	
	public List<LeaderBoardEntity> compareLeague(List<LeaderBoardEntity> oldLeagueData, List<LeaderBoardEntity> newLeagueData) {
		LOG.info("compareLeague called : attempting to compare league data to determine rank differences for league : {} - {}", newLeagueData.get(0).getLeague(), newLeagueData.get(0).getLeaderboard());
		List<LeaderBoardEntity> comparedLeagueList = new ArrayList<>();
		for (LeaderBoardEntity newLeagueDataEntry : newLeagueData) {
			for (LeaderBoardEntity oldLeagueDataEntry : oldLeagueData) {
				comparedLeagueList = new ArrayList<>(newLeagueData);
				if(newLeagueDataEntry.getCharacterId().equals(oldLeagueDataEntry.getCharacterId())
					&& newLeagueDataEntry.getLeague().equals(oldLeagueDataEntry.getLeague())
					&& newLeagueDataEntry.getLeaderboard().equals(oldLeagueDataEntry.getLeaderboard())) {					
					comparedLeagueList.add(performComparison(oldLeagueDataEntry, newLeagueDataEntry));
				} else {
					comparedLeagueList.add(newLeagueDataEntry);
				}
			}				
		}			    		
		return comparedLeagueList;		
	}
	
	private LeaderBoardEntity performComparison(LeaderBoardEntity oldLeagueDataEntry, LeaderBoardEntity newLeagueDataEntry) {
		LeaderBoardEntity comparedleagueEntry = newLeagueDataEntry;			
		if(comparedleagueEntry.getLeaderboard().equals(LeaderboardType.RACETO100.toString())) {			
			comparedleagueEntry.setRankDifference(calcRankDifference(oldLeagueDataEntry, newLeagueDataEntry));
			comparedleagueEntry.setExperienceDifference(calcXpDifference(oldLeagueDataEntry, newLeagueDataEntry));			
		} else if(comparedleagueEntry.getLeaderboard().equals(LeaderboardType.DELVE.toString())) {
			comparedleagueEntry.setRankDifference(calcRankDifference(oldLeagueDataEntry, newLeagueDataEntry));
			comparedleagueEntry.setDepthDifference(calcDepthDifference(oldLeagueDataEntry, newLeagueDataEntry));
		} else if(comparedleagueEntry.getLeaderboard().equals(LeaderboardType.UBERLAB.toString())) {
			comparedleagueEntry.setRankDifference(calcRankDifference(oldLeagueDataEntry, newLeagueDataEntry));
			comparedleagueEntry.setTimeDifference(calcTimeDifference(oldLeagueDataEntry, newLeagueDataEntry));
		}
		return comparedleagueEntry;
	}
	
	private String calcXpDifference(LeaderBoardEntity oldXp, LeaderBoardEntity newXp) {
		String oldXpAsString="0";		
		if(oldXp != null) {
			oldXpAsString = removeCommasFromXpValue(oldXp.getExperience());
		} 		
		String newXpAsString="0";
		if(newXp != null) {
			newXpAsString = removeCommasFromXpValue(newXp.getExperience());
		}		
		return formatXpDifference(performCalculation(oldXpAsString, newXpAsString));		
	}
	
	private String removeCommasFromXpValue(String xpValue) {
		return xpValue.replaceAll(",", "");
	}
	
	private String formatXpDifference(String xpDifference) {
		Double xpDifferenceAsDouble = Double.parseDouble(xpDifference);
		return String.format("%.2fM", xpDifferenceAsDouble/ 1000000.0);		
	}

	private String calcTimeDifference(LeaderBoardEntity oldLeagueDataEntry, LeaderBoardEntity newLeagueDataEntry) {
		return performCalculation(oldLeagueDataEntry.getTime(), newLeagueDataEntry.getTime());
	}
	
	private String calcDepthDifference(LeaderBoardEntity oldLeagueDataEntry, LeaderBoardEntity newLeagueDataEntry) {
		return performCalculation(oldLeagueDataEntry.getRank(), newLeagueDataEntry.getRank());		
	}
	
	private String calcRankDifference(LeaderBoardEntity oldEntry, LeaderBoardEntity newEntry) {
		return formatRank(performCalculation(newEntry.getRank(), oldEntry.getRank()));
	}	
	
	private String performCalculation(String oldValue, String newValue) {
		Long oldValueAsLong = Long.parseLong(oldValue);
		Long newValueAsLong = Long.parseLong(newValue);
		Long difference = newValueAsLong - oldValueAsLong;
		return difference.toString();
	}
		
	private String formatRank(String rankDifference) {
		Long difference = Long.parseLong(rankDifference);
		if(difference > 0) {
			return "+" + difference;
		}
		return rankDifference;
	}
	
}
	