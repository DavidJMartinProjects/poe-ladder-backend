package com.poe.ladder.backend.external.api.requests.urls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poe.ladder.backend.external.api.requests.LeaderboardApiRequestServiceImpl;
import com.poe.ladder.backend.leaderboard.domain.LeagueName;
import com.poe.ladder.backend.leagues.business.LeagueNameService;

@Component
public class LeaderboardUrlBuilder {
	
	@Autowired
	LeagueNameService leagueNameService;
	
	@Autowired
	LeaderboardApiUrlsConfig urlsConfig;
	
	private List<LeagueName> leagueNames;
	private Map<String, String> delveUrls;
	private Map<String, String> uberLabUrls;
	private Map<String, String> raceTo100Urls;
	private List<Map<String, String>> leaderBoardUrls;	
	
	private static final Logger LOG = LoggerFactory.getLogger(LeaderboardUrlBuilder.class);
	
	public LeaderboardUrlBuilder() {
		leagueNames = new ArrayList<>();
		delveUrls = new HashMap<>();
		raceTo100Urls = new HashMap<>();
		uberLabUrls = new HashMap<>();
		leaderBoardUrls = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		leagueNames = leagueNameService.getLeagueVariationNames();
		buildUrls();
	}

	private void buildUrls() {
		LOG.info("buildUrls(): request received to build leaderboard Urls");
		for (LeagueName leagueName : leagueNames) {
			buildDelveUrls(leagueName.getLeagueName());
			buildUberLabUrls(leagueName.getLeagueName());
			buildRaceTo100Urls(leagueName.getLeagueName());
		}
	}
	
	public List<Map<String, String>> getLeaderBoardUrls() {
		LOG.info("getLeaderBoardUrls(): request received to retrieve leaderboard Urls");
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

	public String getCustomLeagueUrl() {
		return urlsConfig.getCustomLeaguePrefix();
	}

}
		