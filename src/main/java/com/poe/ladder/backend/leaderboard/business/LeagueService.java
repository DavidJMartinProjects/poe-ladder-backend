package com.poe.ladder.backend.leaderboard.business;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

public interface LeagueService {
	List<LeaderBoardEntry> getLeaderboards(String leagueName, String leaderboard);
}
