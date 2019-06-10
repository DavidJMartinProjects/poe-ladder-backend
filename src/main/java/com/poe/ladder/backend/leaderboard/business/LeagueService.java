package com.poe.ladder.backend.leaderboard.business;

import java.util.List;

import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

public interface LeagueService {
	List<LeaderBoardEntity> getLeaderboards(String leagueName, String leaderboard);
}
