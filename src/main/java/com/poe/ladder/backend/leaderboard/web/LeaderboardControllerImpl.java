package com.poe.ladder.backend.leaderboard.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.leaderboard.business.CustomLeagueService;
import com.poe.ladder.backend.leaderboard.business.LeagueNameService;
import com.poe.ladder.backend.leaderboard.config.LeaderboardResultsLimitConfig;
import com.poe.ladder.backend.leaderboard.dao.LeagueDao;
import com.poe.ladder.backend.leaderboard.repository.LeaderboardRepository;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

import lombok.NonNull;

@RestController
public class LeaderboardControllerImpl implements LeaderboardController {
	
	@Autowired
	LeaderboardRepository leaderboardRepository;
	
	@Autowired
	LeagueDao leagueDao;		
	
	@Autowired
	LeagueNameService leagueNameService;
	
	@Autowired
	CustomLeagueService customLeagueService;
	
	@Autowired
	LeaderboardResultsLimitConfig leaderboardResultsLimitConfig;		

	@GetMapping("/leaderboards")
	public List<LeaderBoardEntity> getTop5Leaderboards(@RequestParam @NonNull String leagueName, @RequestParam @NonNull String leaderboard) {
		return leagueDao.getTop5Leaderboards(leagueName, leaderboard);
	}
	
	@GetMapping("/leaderboard-ladder")
	public List<LeaderBoardEntity> getTop100ByLeaderboard(@RequestParam @NonNull String leagueName, @RequestParam @NonNull String leaderboard) {
		return leagueDao.getTop100ByLeaderboard(leagueName, leaderboard);
	}
	
	@GetMapping("/custom-league")
	public List<LeaderBoardEntity> getCustomLeagueLeaderboard(@RequestParam @NonNull String leagueName) {
		return customLeagueService.getCustomLeagueLeaderboard(leagueName);
	}

}	
