package com.poe.ladder.backend.leaderboard.api.business;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeaderboardBase;

public interface LeaderboardService {
	public List<LeaderboardBase> retrieveLeaderBoardData(List<String> leagueNames);
}
