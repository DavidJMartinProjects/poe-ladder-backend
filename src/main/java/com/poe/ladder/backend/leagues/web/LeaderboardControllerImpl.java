package com.poe.ladder.backend.leagues.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.leaderboard.dao.LeaderboardRepository;
import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;
import com.poe.ladder.backend.leagues.business.LeagueNameService;
import com.poe.ladder.backend.leagues.config.LeaderboardResultsLimitConfig;

@RestController
public class LeaderboardControllerImpl implements LeaderboardController {
	
	@Autowired
	LeaderboardRepository leaderboardRepository;
	
	@Autowired
	LeagueNameService leagueNameService;
	
	@Autowired
	CustomLeagueService customLeagueService;
	
	@Autowired
	LeaderboardResultsLimitConfig leaderboardResultsLimitConfig;		

	@GetMapping("/leaderboards")
	public List<LeaderBoardEntry> getLeaderboards(@RequestParam String leagueName, @RequestParam String leaderboard) {
		// make this a one liner and do processing at the dao layer
		List<LeaderBoardEntry> leaderboardResults = new ArrayList<>();
		for (String leagueVariation : leagueNameService.getLeagueVariationsListByLeagueName(leagueName)) {
			leaderboardResults.addAll(leaderboardRepository.getLeaderboardEntryResults(leagueVariation, leaderboard, leaderboardResultsLimitConfig.getResultslimit()));	
		}
		return leaderboardResults;
	}
	
	@GetMapping("/leaderboard-ladder")
	public List<LeaderBoardEntry> getLeaderboardByLeagueVariation(@RequestParam String leagueName, @RequestParam String leaderboard) {
		List<LeaderBoardEntry> leaderboardResults = new ArrayList<>();
			leaderboardResults.addAll(leaderboardRepository.getLeaderboardLadderResults(leagueName, leaderboard));	
		return leaderboardResults;
	}
	
	@GetMapping("/custom-league")
	public List<LeaderBoardEntry> getCustomLeagueLeaderboard(@RequestParam String leagueName) {
		return customLeagueService.getCustomLeagueLeaderboard(leagueName);
	}

}	
