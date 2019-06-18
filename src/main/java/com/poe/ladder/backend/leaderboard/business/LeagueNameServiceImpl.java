package com.poe.ladder.backend.leaderboard.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.domain.LeagueName;
import com.poe.ladder.backend.leagues.config.LeagueVariationsConfig;

@Service
public class LeagueNameServiceImpl implements LeagueNameService {

	@Autowired
	LeagueVariationsConfig leagueVariationsConfig;
	
	private Map<String, List<String>> leagueVariationMap;
	
	@PostConstruct
	private void init() {
		leagueVariationMap = leagueVariationsConfig.getLeagueVariations();
	}
	
	@Override	
	public List<LeagueName> getCurrentLeagues() {				
		List<LeagueName> leagueNamesList = new ArrayList<>();
		for (Map.Entry<String, List<String>> leagueEntry : leagueVariationMap.entrySet()) {
			leagueNamesList.add(new LeagueName(leagueEntry.getKey()));
		}
		checkListIsNotEmpty(leagueNamesList);
		return leagueNamesList;
	}


	@Override
	public List<LeagueName> getLeagueVariationNames() {
		List<LeagueName> leagueVariationsList = new ArrayList<>();
		for (Map.Entry<String, List<String>> leagueEntry : leagueVariationMap.entrySet()) {
			for(String leagueVariation : leagueEntry.getValue()) {
				leagueVariationsList.add(new LeagueName(leagueVariation));
			}
		}
		checkListIsNotEmpty(leagueVariationsList);
		return leagueVariationsList;
	}

	public List<String> getLeagueVariationsListByLeagueName(String leagueName) {
		List<String> leagueVariationsList = new ArrayList<>();
		for (Map.Entry<String, List<String>> leagueEntry : leagueVariationMap.entrySet()) {
			if (leagueEntry.getKey().equals(leagueName)) {
				leagueVariationsList = leagueEntry.getValue();
			}
		}
		checkListIsNotEmpty(leagueVariationsList);
		return leagueVariationsList;
	}

	private void checkListIsNotEmpty(List<?> leagueNamesList) {
		if (leagueNamesList.isEmpty()) {
			throw new RuntimeException("RuntimeException : League Variations not found for leagueName");
		}
	}	
	
}
