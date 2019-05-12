package com.poe.ladder.backend.leaderboard.polling;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.external.api.requests.LeaderboardApiRequestService;
import com.poe.ladder.backend.external.api.requests.urls.LeaderboardUrlsService;
import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.external.api.response.mapper.LeaderboardMappingService;
import com.poe.ladder.backend.leaderboard.dao.LeaderboardRepository;
import com.poe.ladder.backend.leaderboard.domain.BaseEntry;	
	
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

	@PostConstruct
	public void init() throws InterruptedException {
		getLeaderboardRankings();
	}

	@Override
	public void getLeaderboardRankings() {
		leaderboardUrls = leaderboardUrlsService.getLeaderboardUrls();
		for (Map<String, String> urlsList : leaderboardUrls) {
			for (Map.Entry<String, String> leagueUrl : urlsList.entrySet()) {
				apiResponseList = requestLeaderboardFromPoeApi(leagueUrl.getValue());
				List<BaseEntry> leaderboardEntities = mapApiResponseToEntityList(apiResponseList, leagueUrl.getValue(), leagueUrl.getKey());
				persistEntityToDb(leaderboardEntities);
			}			
		}
	}	

	private List<Entry> requestLeaderboardFromPoeApi(String value) {
		return leaderboardApiRequestService.requestLeaderboardFromPoeApi(value);
	}

	private List<BaseEntry> mapApiResponseToEntityList(List<Entry> apiResponseList, String requestUrl, String leagueName) {
		return leaderboardMappingService.mapApiResponseToEntity(apiResponseList, requestUrl, leagueName);
	}

	private void persistEntityToDb(List<BaseEntry> leaderboardEntries) {
		leaderboardRepository.saveAll(leaderboardEntries);		
	}
	
}
	