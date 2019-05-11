package com.poe.ladder.backend.leaderboard.api.business;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeaderboardBase;

public interface PoeApiRequestService {	
	public List<LeaderboardBase> getLeaderboards(List leagueNames);
}
