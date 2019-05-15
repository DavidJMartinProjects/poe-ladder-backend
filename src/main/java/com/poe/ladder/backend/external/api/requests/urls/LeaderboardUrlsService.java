package com.poe.ladder.backend.external.api.requests.urls;

import java.util.List;
import java.util.Map;

public interface LeaderboardUrlsService {
	List<Map<String, String>> getLeaderboardUrls();
	String getCustomLeagueUrl();
}
