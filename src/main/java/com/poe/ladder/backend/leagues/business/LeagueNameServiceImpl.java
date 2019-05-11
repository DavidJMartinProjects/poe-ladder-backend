package com.poe.ladder.backend.leagues.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leagues.config.LeagueNamesConfig;

@Service	
public class LeagueNameServiceImpl implements LeagueNameService {
		
	@Autowired
	public LeagueNamesConfig leagueNameConfig;

	@Override
	public List<String> getLeagueNames() {
		return leagueNameConfig.getCurrentLeagues();
	}	

}
	