package com.poe.ladder.backend.external.api.requests.urls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poe.ladder.backend.leagues.business.LeagueNameService;

@Component
public class LeaderboardUrlBuilder {
	
	@Autowired
	LeagueNameService leagueNameService;
	
	@Autowired
	LeaderboardApiUrlsConfig urlsConfig;
	
	private List<String> leagueNames;
	private Map<String, String> delveUrls;
	private Map<String, String> uberLabUrls;
	private Map<String, String> raceTo100Urls;
	private List<Map<String, String>> leaderBoardUrls; 
	
	public LeaderboardUrlBuilder() {
		leagueNames = new ArrayList<String>();
		delveUrls = new HashMap<String, String>();
		raceTo100Urls = new HashMap<String, String>();
		uberLabUrls = new HashMap<String, String>();
		leaderBoardUrls = new ArrayList<Map<String,String>>();
	}

	@PostConstruct
	public void init() {
		leagueNames = leagueNameService.getCurrentLeagues();
		buildUrls();
	}

	private void buildUrls() {
		for (String leagueName : leagueNames) {
			buildDelveUrls(leagueName);
			buildUberLabUrls(leagueName);
			buildRaceTo100Urls(leagueName);
		}
	}
	
	public List<Map<String, String>> getLeaderBoardUrls() {
		leaderBoardUrls.add(delveUrls);
		leaderBoardUrls.add(uberLabUrls);
		leaderBoardUrls.add(raceTo100Urls);
		return leaderBoardUrls;
	}
	
	private void buildDelveUrls(String leagueName) {
		String url = "" + urlsConfig.getDelvePrefix() + leagueName + urlsConfig.getDelvePostfix();		
		delveUrls.put(leagueName, url);
	}
	
	private void buildUberLabUrls(String leagueName) {
		String url = "" + urlsConfig.getUberlabPrefix() + leagueName + urlsConfig.getUberlabPostfix();		
		uberLabUrls.put(leagueName, url);
	}
	
	private void buildRaceTo100Urls(String leagueName) {
		String url = "" + urlsConfig.getRaceto100Prefix() + leagueName + urlsConfig.getRaceto100Postfix();		
		raceTo100Urls.put(leagueName, url);
	}
		
}
		