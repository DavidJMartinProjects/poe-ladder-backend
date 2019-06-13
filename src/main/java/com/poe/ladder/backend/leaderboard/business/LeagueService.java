package com.poe.ladder.backend.leaderboard.business;

import java.util.List;

import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

public interface LeagueService {
	List<LeaderBoardEntity> getTop5Leaderboards(String leagueName, String leaderboard);
	List<LeaderBoardEntity> getTop100ByLeaderboard(String leagueName, String leaderboard);
}
