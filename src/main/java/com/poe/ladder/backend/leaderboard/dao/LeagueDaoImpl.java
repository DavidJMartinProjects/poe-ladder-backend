package com.poe.ladder.backend.leaderboard.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.business.LeagueService;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

@Service	
public class LeagueDaoImpl implements LeagueDao {
	
	Logger logger = LoggerFactory.getLogger(LeagueDaoImpl.class);
	
	@Autowired
	LeagueService leagueService;

	@Override
	public List<LeaderBoardEntity> getLeaderboardLadderResults(String leagueName, String leaderboard) {
		logger.info("getLeaderboardLadderResults() : DAO called : request params : leagueName = {} and leaderboard = {}", leagueName, leaderboard);
		return leagueService.getLeaderboards(leagueName, leaderboard);
	}	
	
}