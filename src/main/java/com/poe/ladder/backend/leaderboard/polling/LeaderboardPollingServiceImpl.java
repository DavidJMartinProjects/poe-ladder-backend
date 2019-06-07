package com.poe.ladder.backend.leaderboard.polling;

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
import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;
import com.poe.ladder.backend.leaderboard.repository.LeaderboardRepository;		
	
@Service
public class LeaderboardPollingServiceImpl implements LeaderboardPollingService {		

	@Autowired
	LeaderboardUrlsService leaderboardUrlsService;

	@Autowired
	LeaderboardApiRequestService leaderboardApiRequestService;	

	@Autowired
	LeaderboardMappingService leaderboardMappingService;		
	
	@Autowired
	LeaderboardRepository leaderboardRepository;	

	private List<Entry> apiResponseList;               
	private List<Map<String, String>> leaderboardUrls;
	private List<LeaderBoardEntry> leaderboardEntities = new ArrayList<>();	
	private final static Logger LOG = LoggerFactory.getLogger(LeaderboardPollingServiceImpl.class);
	
	@PostConstruct
	public void init() {
		leaderboardUrls = leaderboardUrlsService.getLeaderboardUrls();
	}

	@Override
	public void getLeaderboardRankings() {		
		LOG.info("getLeaderboardRankings() : attempting to retrieve latest ladders from pathofexile.com");
		leaderboardEntities.clear();		
		for (Map<String, String> urlsList : leaderboardUrls) {
			for (Map.Entry<String, String> leagueUrl : urlsList.entrySet()) {
				apiResponseList = requestLeaderboardFromPoeApi(leagueUrl.getValue());
				leaderboardEntities.addAll(mapApiResponseToEntityList(apiResponseList, leagueUrl.getValue(), leagueUrl.getKey()));
			}			
		}
		persistEntityToDb(leaderboardEntities);
	}	

	private List<Entry> requestLeaderboardFromPoeApi(String value) {
		return leaderboardApiRequestService.requestLeaderboardFromPoeApi(value);
	}

	private List<LeaderBoardEntry> mapApiResponseToEntityList(List<Entry> apiResponseList, String requestUrl, String leagueName) {
		return leaderboardMappingService.mapApiResponseToEntity(apiResponseList, requestUrl, leagueName);
	}

	private void persistEntityToDb(List<LeaderBoardEntry> leaderboardEntries) {
		LOG.info("persistEntityToDb() : saving leaderboard results to poe-ladder database.");
		leaderboardRepository.deleteAll();
		leaderboardRepository.flush();
		leaderboardRepository.saveAll(leaderboardEntries);
	}
	
}
	