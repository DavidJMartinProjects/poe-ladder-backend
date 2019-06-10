package com.poe.ladder.backend.leaderboard.dao;

import java.util.List;

import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

public interface LeagueDao {
	List<LeaderBoardEntity> getLeaderboardLadderResults(String leagueName, String leaderboard);	
}
