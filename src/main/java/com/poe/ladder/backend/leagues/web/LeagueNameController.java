package com.poe.ladder.backend.leagues.web;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.League;

public interface LeagueNameController {	
	public List<League> getCurrentLeagues();
	public List<League> getLeagueNames();
}	
