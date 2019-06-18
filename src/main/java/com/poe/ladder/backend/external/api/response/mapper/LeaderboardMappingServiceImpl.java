package com.poe.ladder.backend.external.api.response.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poe.ladder.backend.external.api.requests.urls.LeaderboardApiUrlsConfig;
import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.business.LeagueNameService;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;
import com.poe.ladder.backend.util.MappingUtil;

@Component
public class LeaderboardMappingServiceImpl implements LeaderboardMappingService {

	@Autowired
	MappingUtil formatUtil;

	@Autowired
	LeagueNameService leagueNameService;
	
	@Autowired
	LeaderboardMappingUtil leaderboardMappingUtil;

	@Autowired
	LeaderboardApiUrlsConfig leaderboardApiUrlsConfig;

	private List<LeaderBoardEntity> leaderBoardEntityList = new ArrayList<>();		
	private static final Logger LOG = LoggerFactory.getLogger(LeaderboardMappingServiceImpl.class);

	public List<LeaderBoardEntity> mapApiResponseToEntity(List<Entry> apiResponseList, String requestUrl, String leagueName, String timestamp) {
		LOG.info("mapApiResponseToEntity(): request received to map api response to leaderboard entity");
		leaderBoardEntityList.clear();		
		LeaderboardType leaderboardType = determineLeaderboardType(requestUrl);
		for (Entry responseEntry : apiResponseList) {
			LeaderBoardEntity leaderboardEntity = leaderboardMappingUtil.mapToLeaderboardEntry(leagueName, leaderboardType, responseEntry, timestamp);
			leaderBoardEntityList.add(leaderboardEntity);
		}
		return leaderBoardEntityList;
	}

	private LeaderboardType determineLeaderboardType(String url) {
		if (url.contains(leaderboardApiUrlsConfig.getDelvePostfix())) {
			return LeaderboardType.DELVE;
		} else if (url.contains(leaderboardApiUrlsConfig.getUberlabPostfix())) {
			return LeaderboardType.UBERLAB;
		} else if (url.contains(leaderboardApiUrlsConfig.getRaceto100Postfix())) {
			return LeaderboardType.RACETO100;
		}
		return LeaderboardType.UNKNOWN;
	}
		
}
