package com.poe.ladder.backend.external.api.requests.urls;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardUrlsServiceImpl implements LeaderboardUrlsService {

	@Autowired
	LeaderboardUrlBuilder leaderboardUrlBuilder;
	@Override
	public List<Map<String, String>> getLeaderboardUrls() {
		return leaderboardUrlBuilder.getLeaderBoardUrls();
	}

}
