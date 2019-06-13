package com.poe.ladder.backend.external.api.requests.urls;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardUrlsServiceImpl implements LeaderboardUrlsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(LeaderboardUrlsServiceImpl.class);

	@Autowired
	LeaderboardUrlBuilder leaderboardUrlBuilder;
	
	@Override
	public List<Map<String, String>> getLeaderboardUrls() {
		LOG.info("getLeaderboardUrls(): requesting leaderboard urls");
		return leaderboardUrlBuilder.getLeaderBoardUrls();
	}
	
	public String getCustomLeagueUrl() {
		LOG.info("getCustomLeagueUrl(): requesting custom leaderboard urls");
		return leaderboardUrlBuilder.getCustomLeagueUrl();
	}

}
		