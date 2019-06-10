package com.poe.ladder.backend.leaderboard.comparison;

import java.util.List;

import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

public interface LeagueComparisonService {
	List<LeaderBoardEntity> compareLeague(List<LeaderBoardEntity> oldLeagueData, List<LeaderBoardEntity> newLeagueData);
}
	