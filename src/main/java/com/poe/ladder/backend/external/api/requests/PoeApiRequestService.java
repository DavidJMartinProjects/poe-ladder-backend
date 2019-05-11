package com.poe.ladder.backend.external.api.requests;

import java.util.List;
import java.util.Map;

import com.poe.ladder.backend.leaderboard.domain.LeaderboardEntry;

public interface PoeApiRequestService {	
	// service for internal calls to retrive data from pathofexile.com api
	void getLeaderboardRankings();
}
