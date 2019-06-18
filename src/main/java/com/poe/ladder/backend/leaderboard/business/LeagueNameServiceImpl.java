package com.poe.ladder.backend.leaderboard.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.domain.LeagueName;
import com.poe.ladder.backend.leagues.config.LeagueVariationsConfig;

@Service
public class LeagueNameServiceImpl implements LeagueNameService {

	@Autowired
	LeagueVariationsConfig leagueVariationsConfig;
	
	@Override	
	public List<LeagueName> getCurrentLeagues() {		
		Map<String, List<String>> leagueVariationMap = leagueVariationsConfig.getLeagueVariations();
		List<LeagueName> leagueNamesList = new ArrayList<>();
		for (Map.Entry<String, List<String>> leagueEntry : leagueVariationMap.entrySet()) {
			leagueNamesList.add(new LeagueName(leagueEntry.getKey()));
		}
		if (leagueNamesList.isEmpty()) {
			throw new RuntimeException("getCurrentLeagues() encountered a RuntimeException : League Variations not found for leagueName");
		}
		return leagueNamesList;
	}	

	@Override
	public List<LeagueName> getLeagueVariationNames() {
		Map<String, List<String>> leagueVariationMap = leagueVariationsConfig.getLeagueVariations();
		List<LeagueName> leagueVariationsList = new ArrayList<>();
		for (Map.Entry<String, List<String>> leagueEntry : leagueVariationMap.entrySet()) {
			for(String leagueVariation : leagueEntry.getValue()) {
				leagueVariationsList.add(new LeagueName(leagueVariation));
			}
		}
		if (leagueVariationsList.isEmpty()) {
			throw new RuntimeException("getLeagueVariationNames() encountered a RuntimeException : League Variations not found for leagueName");
		}
		return leagueVariationsList;
	}

	public List<String> getLeagueVariationsListByLeagueName(String leagueName) {
		Map<String, List<String>> leagueVariationMap = leagueVariationsConfig.getLeagueVariations();
		List<String> leagueVariationsList = new ArrayList<>();
		for (Map.Entry<String, List<String>> leagueEntry : leagueVariationMap.entrySet()) {
			if (leagueEntry.getKey().equals(leagueName)) {
				leagueVariationsList = leagueEntry.getValue();
			}
		}
		if (leagueVariationsList.isEmpty()) {
			throw new RuntimeException("getLeagueVariationsListByLeagueName() encountered a RuntimeException  : League Variations not found for leagueName : " + leagueName);
		}
		return leagueVariationsList;
	}

}
