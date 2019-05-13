package com.poe.ladder.backend.leagues.web;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeagueName;

public interface LeagueNameController {	
	public List<String> getCurrentLeagues();
	public List<LeagueName> getLeagueNames();
}	
