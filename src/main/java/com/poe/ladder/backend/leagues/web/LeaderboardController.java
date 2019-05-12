package com.poe.ladder.backend.leagues.web;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

public interface LeaderboardController {
	List<LeaderBoardEntry> getDelveLeaderboard();
	List<LeaderBoardEntry> getUberlabLeaderboard();
	List<LeaderBoardEntry> getRaceTo100Leaderboard();
}
	