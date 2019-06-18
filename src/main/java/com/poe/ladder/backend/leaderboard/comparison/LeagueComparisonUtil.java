package com.poe.ladder.backend.leaderboard.comparison;

import org.springframework.stereotype.Component;

import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;
import com.poe.ladder.backend.util.MappingUtil;

@Component
public class LeagueComparisonUtil {
	
	public String compareTimeDifference(LeaderBoardEntity oldLeagueDataEntry, LeaderBoardEntity newLeagueDataEntry) {
		return calculateDifference(oldLeagueDataEntry.getTime(), newLeagueDataEntry.getTime());
	}
	
	public String compareDepthDifference(LeaderBoardEntity oldLeagueDataEntry, LeaderBoardEntity newLeagueDataEntry) {
		return calculateDifference(oldLeagueDataEntry.getRank(), newLeagueDataEntry.getRank());		
	}
	
	public String compareRankDifference(LeaderBoardEntity oldEntry, LeaderBoardEntity newEntry) {
		return MappingUtil.formatRank(calculateDifference(newEntry.getRank(), oldEntry.getRank()));
	}	
	
	public String calcXpDifference(LeaderBoardEntity oldXp, LeaderBoardEntity newXp) {
		String oldXpAsString="0";		
		if(oldXp != null) {
			oldXpAsString = MappingUtil.removeCommasFromXpValue(oldXp.getExperience());
		} 		
		String newXpAsString="0";
		if(newXp != null) {
			newXpAsString = MappingUtil.removeCommasFromXpValue(newXp.getExperience());
		}		
		return MappingUtil.formatXpDifference(calculateDifference(oldXpAsString, newXpAsString));		
	}
	
	private String calculateDifference(String oldValue, String newValue) {
		Long oldValueAsLong = Long.parseLong(oldValue);
		Long newValueAsLong = Long.parseLong(newValue);
		Long difference = newValueAsLong - oldValueAsLong;
		return difference.toString();
	}

}
