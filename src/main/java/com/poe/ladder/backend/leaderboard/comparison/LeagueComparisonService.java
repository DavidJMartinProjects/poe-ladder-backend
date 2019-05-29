package com.poe.ladder.backend.leaderboard.comparison;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

public interface LeagueComparisonService {
	List<LeaderBoardEntry> compareLeague(List<LeaderBoardEntry> oldLeagueData, List<LeaderBoardEntry> newLeagueData);
}
	