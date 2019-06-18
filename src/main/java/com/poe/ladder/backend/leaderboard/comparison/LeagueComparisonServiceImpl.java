package com.poe.ladder.backend.leaderboard.comparison;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

@Service
public class LeagueComparisonServiceImpl implements LeagueComparisonService {
	
	@Autowired
	LeagueComparisonUtil leagueComparisonUtil;	
	
	private static final Logger LOG = LoggerFactory.getLogger(LeagueComparisonServiceImpl.class);
	
	public List<LeaderBoardEntity> compareLeague(List<LeaderBoardEntity> oldLeagueData, List<LeaderBoardEntity> newLeagueData) {
		LOG.info("compareLeague() called : attempting to compare league data to determine rank differences");
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
		comparedleagueEntry.setRankDifference(leagueComparisonUtil.calcRankDifference(oldLeagueDataEntry, newLeagueDataEntry));
		if(comparedleagueEntry.getLeaderboard().equals(LeaderboardType.RACETO100.toString())) {			
			comparedleagueEntry.setExperienceDifference(leagueComparisonUtil.calcXpDifference(oldLeagueDataEntry, newLeagueDataEntry));			
		} else if(comparedleagueEntry.getLeaderboard().equals(LeaderboardType.DELVE.toString())) {
			comparedleagueEntry.setDepthDifference(leagueComparisonUtil.calcDepthDifference(oldLeagueDataEntry, newLeagueDataEntry));
		} else if(comparedleagueEntry.getLeaderboard().equals(LeaderboardType.UBERLAB.toString())) {
			comparedleagueEntry.setTimeDifference(leagueComparisonUtil.calcTimeDifference(oldLeagueDataEntry, newLeagueDataEntry));
		}
		return comparedleagueEntry;
	}
	
}
	