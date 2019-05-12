package com.poe.ladder.backend.leaderboard.polling;

public interface LeaderboardPollingService {	
	void getLeaderboardRankings() throws InterruptedException;
}
	