package com.poe.ladder.backend.leaderboard.dao;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

public interface LeagueDao {
	List<LeaderBoardEntry> getLeaderboardLadderResults(String leagueName, String leaderboard);	
}
