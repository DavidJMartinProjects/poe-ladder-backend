package com.poe.ladder.backend.leaderboard.api.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.poe.ladder.backend.leaderboard.domain.LeaderboardBase;
import com.poe.ladder.backend.leagues.business.LeagueNameService;

public class LeaderboardServiceImpl implements LeaderboardService {
	
	@Autowired
	LeagueNameService leagueNameService;
	
	@Autowired
	PoeApiRequestService poeApiRequestService;

	@Override
	public List<LeaderboardBase> retrieveLeaderBoardData(List<String> leagueNames) {
		return poeApiRequestService.getLeaderboards(leagueNameService.getCurrentLeagues());		
	}
	
}		
