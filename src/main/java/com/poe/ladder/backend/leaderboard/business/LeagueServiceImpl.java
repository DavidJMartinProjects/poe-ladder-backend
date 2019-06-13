package com.poe.ladder.backend.leaderboard.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.repository.LeaderboardRepository;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;
import com.poe.ladder.backend.leagues.config.LeaderboardResultsLimitConfig;

@Service	
public class LeagueServiceImpl implements LeagueService {
	
	@Autowired
	LeaderboardRepository leaderboardRepository;
	
	@Autowired
	LeaderboardResultsLimitConfig leaderboardResultsLimitConfig;
	
	@Autowired
	LeagueNameService leagueNameService;
	
	Logger logger = LoggerFactory.getLogger(LeagueServiceImpl.class);

	@Override
	@Cacheable("leaderboards")
	public List<LeaderBoardEntity> getTop5Leaderboards(String leagueName, String leaderboard) {		
		logger.info("getTop5Leaderboards() : Calling DB Respository.");
		List<LeaderBoardEntity> leaderboardResults = new ArrayList<>();
		for (String leagueVariation : leagueNameService.getLeagueVariationsListByLeagueName(leagueName)) {
			leaderboardResults.addAll(leaderboardRepository.getTop5ByLeague(leagueVariation, leaderboard, leaderboardResultsLimitConfig.getResultslimit()));	
		}
		return leaderboardResults;	
	}
	
	@Override
	@Cacheable("leaderboardsTop100")
	public List<LeaderBoardEntity> getTop100ByLeaderboard(String leagueName, String leaderboard) {		
		logger.info("getTop100Leaderboards() : Calling DB Respository.");
		return leaderboardRepository.getTop100ByLeaderboard(leagueName, leaderboard);	
	}

}
		