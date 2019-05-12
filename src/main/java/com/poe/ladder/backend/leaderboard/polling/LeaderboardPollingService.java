package com.poe.ladder.backend.leaderboard.polling;

public interface LeaderboardPollingService {	
	// service for internal calls to retrive data from pathofexile.com api
	void getLeaderboardRankings() throws InterruptedException;
}
	