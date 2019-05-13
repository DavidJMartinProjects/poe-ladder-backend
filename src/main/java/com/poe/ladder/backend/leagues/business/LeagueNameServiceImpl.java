package com.poe.ladder.backend.leagues.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.domain.LeagueName;
import com.poe.ladder.backend.leagues.config.LeagueNamesConfig;

@Service	
public class LeagueNameServiceImpl implements LeagueNameService {
		
	@Autowired
	public LeagueNamesConfig leagueNameConfig;

	@Override
	public List<String> getCurrentLeagues() {
		return leagueNameConfig.getCurrentLeagues();
	}

	@Override
	public List<LeagueName> getCurrentNames() {	
		List<LeagueName> leagueNames = new ArrayList<LeagueName>();
		for (String leagueName : leagueNameConfig.getLeagueNames()) {
			leagueNames.add(new LeagueName(leagueName));
		}
		return leagueNames;
	}

}
	