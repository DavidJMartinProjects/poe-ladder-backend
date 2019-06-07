package com.poe.ladder.backend.leaderboard.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;
import com.poe.ladder.backend.leaderboard.repository.LeaderboardRepository;
import com.poe.ladder.backend.leagues.business.LeagueNameService;
import com.poe.ladder.backend.leagues.config.LeaderboardResultsLimitConfig;

@Service	
public class LeagueServiceImpl implements LeagueService {
	
	@Autowired
	LeaderboardRepository leaderboardRepository;
	
	@Autowired
	LeaderboardResultsLimitConfig leaderboardResultsLimitConfig;
	
	@Autowired
	LeagueNameService leagueNameService;

	@Override
	public List<LeaderBoardEntry> getLeaderboards(String leagueName, String leaderboard) {		
		// make this a one liner and do processing at the service layer
		List<LeaderBoardEntry> leaderboardResults = new ArrayList<>();
		for (String leagueVariation : leagueNameService.getLeagueVariationsListByLeagueName(leagueName)) {
			leaderboardResults.addAll(leaderboardRepository.getLeaderboardEntryResults(leagueVariation, leaderboard, leaderboardResultsLimitConfig.getResultslimit()));	
		}
		return leaderboardResults;		
	}

}
		