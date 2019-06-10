package com.poe.ladder.backend.leagues.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.leaderboard.dao.LeagueDaoImpl;
import com.poe.ladder.backend.leaderboard.repository.LeaderboardRepository;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;
import com.poe.ladder.backend.leagues.business.LeagueNameService;
import com.poe.ladder.backend.leagues.config.LeaderboardResultsLimitConfig;

@RestController
public class LeaderboardControllerImpl implements LeaderboardController {
	
	@Autowired
	LeaderboardRepository leaderboardRepository;
	
	@Autowired
	LeagueDaoImpl leagueDaoImpl;	
	
	@Autowired
	LeagueNameService leagueNameService;
	
	@Autowired
	CustomLeagueService customLeagueService;
	
	@Autowired
	LeaderboardResultsLimitConfig leaderboardResultsLimitConfig;		

	@GetMapping("/leaderboards")
	public List<LeaderBoardEntity> getLeaderboards(@RequestParam String leagueName, @RequestParam String leaderboard) {
		return leagueDaoImpl.getLeaderboardLadderResults(leagueName, leaderboard);
	}
	
	@GetMapping("/leaderboard-ladder")
	public List<LeaderBoardEntity> getLeaderboardByLeagueVariation(@RequestParam String leagueName, @RequestParam String leaderboard) {
			return leaderboardRepository.getLeaderboardLadderResults(leagueName, leaderboard);	
	}
	
	@GetMapping("/custom-league")
	public List<LeaderBoardEntity> getCustomLeagueLeaderboard(@RequestParam String leagueName) {
		return customLeagueService.getCustomLeagueLeaderboard(leagueName);
	}

}	
