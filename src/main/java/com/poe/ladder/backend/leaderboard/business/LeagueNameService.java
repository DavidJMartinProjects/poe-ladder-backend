package com.poe.ladder.backend.leaderboard.business;

import java.util.List;

import com.poe.ladder.backend.leaderboard.domain.League;

public interface LeagueNameService {	
	public List<League> getCurrentLeagues();
	public List<League>  getLeagueVariationNames();
	public List<String> getLeagueVariationsListByLeagueName(String leagueName);
}
		