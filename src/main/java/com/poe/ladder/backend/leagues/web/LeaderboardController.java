package com.poe.ladder.backend.leagues.web;

import java.util.List;

import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

public interface LeaderboardController {
	List<LeaderBoardEntity> getTop5Leaderboards(String leagueName, String leaderboard);
	List<LeaderBoardEntity> getTop100ByLeaderboard(String leagueName, String leaderboard);	
}
	