package com.poe.ladder.backend.leagues.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.leaderboard.dao.LeaderboardRepository;
import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;

@RestController
public class LeaderboardControllerImpl implements LeaderboardController {
	
	@Autowired
	LeaderboardRepository leaderboardRepository;

	@GetMapping("/leaderboard-delve")
	public List<LeaderBoardEntry> getDelveLeaderboard() {
		return leaderboardRepository.findByLeaderboard(LeaderboardType.DELVE.getValue());
	}

	@GetMapping("/leaderboard-uberlab")
	public List<LeaderBoardEntry> getUberlabLeaderboard() {
		return leaderboardRepository.findByLeaderboard(LeaderboardType.UBERLAB.getValue());
	}

	@GetMapping("/leaderboard-raceto100")
	public List<LeaderBoardEntry> getRaceTo100Leaderboard() {
		return leaderboardRepository.findByLeaderboard(LeaderboardType.RACETO100.getValue());
	}

}	
