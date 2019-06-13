package com.poe.ladder.backend.leaderboard.dao;

import java.util.List;

import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

public interface LeagueDao {
	List<LeaderBoardEntity> getTop5Leaderboards(String leagueName, String leaderboard);
	List<LeaderBoardEntity> getTop100ByLeaderboard(String leagueName, String leaderboard);	
}
