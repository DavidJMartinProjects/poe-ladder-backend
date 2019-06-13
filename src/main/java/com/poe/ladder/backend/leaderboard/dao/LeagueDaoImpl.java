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
	public List<LeaderBoardEntity> getTop5Leaderboards(String leagueName, String leaderboard) {
		logger.info("getTop5Leaderboards() : DAO called : request params : leagueName = {} and leaderboard = {}", leagueName, leaderboard);
		return leagueService.getTop5Leaderboards(leagueName, leaderboard);
	}	
	
	@Override
	public List<LeaderBoardEntity> getTop100ByLeaderboard(String leagueName, String leaderboard) {
		logger.info("getTop100Leaderboards() : DAO called : request params : leagueName = {} and leaderboard = {}", leagueName, leaderboard);
		return leagueService.getTop100ByLeaderboard(leagueName, leaderboard);
	}	
	
}
