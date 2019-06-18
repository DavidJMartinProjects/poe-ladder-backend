package com.poe.ladder.backend.leaderboard.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poe.ladder.backend.external.api.requests.LeaderboardApiRequestService;
import com.poe.ladder.backend.external.api.requests.urls.LeaderboardUrlsService;
import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.external.api.response.mapper.LeaderboardMappingServiceImpl;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;
import com.poe.ladder.backend.util.TimestampUtils;

@Component
public class CustomLeagueServiceImpl implements CustomLeagueService {
	
	@Autowired
	LeaderboardApiRequestService leaderboardApiRequestService;
	
	@Autowired
	LeaderboardUrlsService leaderboardUrlsService;
	
	@Autowired
	LeaderboardMappingServiceImpl leaderboardMappingServiceImpl;	

	@Override
	public List<LeaderBoardEntity> getCustomLeagueLeaderboard(String leagueName) {
		String url = leaderboardUrlsService.getCustomLeagueUrl() + leagueName;
		List<Entry> apiResponseList = leaderboardApiRequestService.requestLeaderboardFromPoeApi(url);
		return leaderboardMappingServiceImpl.mapApiResponseToEntity(apiResponseList, url, leagueName, TimestampUtils.getCurrentTimestamp());
	}

}
		