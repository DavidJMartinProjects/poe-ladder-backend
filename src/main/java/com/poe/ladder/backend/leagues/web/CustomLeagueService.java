package com.poe.ladder.backend.leagues.web;

import java.util.List;

import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

public interface CustomLeagueService {	
	public List<LeaderBoardEntity> getCustomLeagueLeaderboard(String leagueName);
}
	
