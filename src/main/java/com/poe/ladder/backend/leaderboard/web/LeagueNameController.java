package com.poe.ladder.backend.leaderboard.web;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeagueName;

public interface LeagueNameController {	
	public List<LeagueName> getCurrentLeagues();
	public List<LeagueName> getLeagueNames();
}	
