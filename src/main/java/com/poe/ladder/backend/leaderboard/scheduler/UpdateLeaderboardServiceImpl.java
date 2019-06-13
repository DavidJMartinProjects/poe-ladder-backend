package com.poe.ladder.backend.leaderboard.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.external.api.requests.LeaderboardApiRequestService;
import com.poe.ladder.backend.external.api.requests.urls.LeaderboardUrlsService;
import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.external.api.response.mapper.LeaderboardMappingService;
import com.poe.ladder.backend.leaderboard.comparison.LeagueComparisonService;
import com.poe.ladder.backend.leaderboard.repository.LeaderboardRepository;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;
import com.poe.ladder.backend.util.TimestampUtil;		
	
@Service
public class UpdateLeaderboardServiceImpl implements UpdateLeaderboardService {		

	@Autowired
	LeaderboardUrlsService leaderboardUrlsService;

	@Autowired
	LeaderboardApiRequestService leaderboardApiRequestService;	

	@Autowired
	LeaderboardMappingService leaderboardMappingService;			
	
	@Autowired
	LeaderboardRepository leaderboardRepository;	
	
	@Autowired
	LeagueComparisonService leagueComparisonService;
	
	private List<LeaderBoardEntity> previousLeaderboardEntities = new ArrayList<>();	
	private List<Map<String, String>> leaderboardUrls;
	private static final Logger LOG = LoggerFactory.getLogger(UpdateLeaderboardServiceImpl.class);
	
	@PostConstruct
	public void init() {
		leaderboardUrls = leaderboardUrlsService.getLeaderboardUrls();
	}

	@Override
	public void getLeaderboardRankings() {		
		LOG.info("getLeaderboardRankings() : attempting to retrieve latest ladders from pathofexile.com");
		List<LeaderBoardEntity> latestLeaderboardEntities = new ArrayList<>();			
		for (Map<String, String> urlsList : leaderboardUrls) {
			for (Map.Entry<String, String> leagueUrl : urlsList.entrySet()) {				
				List<Entry> apiResponseList = requestLeaderboardFromPoeApi(leagueUrl.getValue());
				latestLeaderboardEntities.addAll(mapApiResponseToEntityList(apiResponseList, leagueUrl.getValue(), leagueUrl.getKey()));
			}			
		}
		if(!previousLeaderboardEntities.isEmpty()) {
			latestLeaderboardEntities = leagueComparisonService.compareLeague(previousLeaderboardEntities, latestLeaderboardEntities);
		} 
		previousLeaderboardEntities = latestLeaderboardEntities;				
		persistEntityToDb(latestLeaderboardEntities);
	}

	private List<Entry> requestLeaderboardFromPoeApi(String value) {
		return leaderboardApiRequestService.requestLeaderboardFromPoeApi(value);
	}

	private List<LeaderBoardEntity> mapApiResponseToEntityList(List<Entry> apiResponseList, String requestUrl, String leagueName) {
		return leaderboardMappingService.mapApiResponseToEntity(apiResponseList, requestUrl, leagueName, TimestampUtil.getCurrentTimestamp());
	}

	private void persistEntityToDb(List<LeaderBoardEntity> leaderboardEntries) {
		LOG.info("persistEntityToDb() : saving leaderboard results to poe-ladder database.");
		leaderboardRepository.deleteAll();
		leaderboardRepository.flush();
		leaderboardRepository.saveAll(leaderboardEntries);
	}
	
}
	