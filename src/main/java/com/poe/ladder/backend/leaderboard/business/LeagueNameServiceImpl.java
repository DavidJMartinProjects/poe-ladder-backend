package com.poe.ladder.backend.leaderboard.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.domain.League;
import com.poe.ladder.backend.leagues.config.LeagueNamesConfig;
import com.poe.ladder.backend.leagues.config.LeagueVariationsConfig;

@Service
public class LeagueNameServiceImpl implements LeagueNameService {

	@Autowired
	LeagueVariationsConfig leagueVariationsConfig;
	
	@Autowired
	LeagueNamesConfig leagueNamesConfig;

	@Override
	public List<League> getCurrentLeagues() {		
		Map<String, List<String>> leagueVariationMap = leagueVariationsConfig.getLeagueVariations();
		List<League> leagueNamesList = new ArrayList<>();
		for (Map.Entry<String, List<String>> leagueEntry : leagueVariationMap.entrySet()) {
			leagueNamesList.add(new League(leagueEntry.getKey()));
		}
		if (leagueNamesList.isEmpty()) {
			throw new RuntimeException("RuntimeException encountered : League Variations not found for leagueName : ");
		}
		return leagueNamesList;
	}	

	@Override
	public List<League> getLeagueVariationNames() {
		Map<String, List<String>> leagueVariationMap = leagueVariationsConfig.getLeagueVariations();
		List<League> leagueVariationsList = new ArrayList<>();
		for (Map.Entry<String, List<String>> leagueEntry : leagueVariationMap.entrySet()) {
			for(String leagueVariation : leagueEntry.getValue()) {
				leagueVariationsList.add(new League(leagueVariation));
			}
		}
		if (leagueVariationsList.isEmpty()) {
			throw new RuntimeException("RuntimeException encountered : League Variations not found for leagueName : ");
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
			throw new RuntimeException("RuntimeException encountered : League Variations not found for leagueName : " + leagueName);
		}
		return leagueVariationsList;
	}

}
