package com.poe.ladder.backend.leagues.business;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.LeagueName;

public interface LeagueNameService {	
	public List<LeagueName> getCurrentLeagues();
	public List<LeagueName>  getLeagueVariationNames();
	public List<String> getLeagueVariationsListByLeagueName(String leagueName);
}
		