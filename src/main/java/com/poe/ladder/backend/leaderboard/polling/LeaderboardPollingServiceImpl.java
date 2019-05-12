package com.poe.ladder.backend.leaderboard.polling;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.external.api.requests.LeaderboardApiRequestService;
import com.poe.ladder.backend.external.api.requests.urls.LeaderboardApiUrlsConfig;
import com.poe.ladder.backend.external.api.requests.urls.LeaderboardUrlsService;
import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.external.api.response.mapper.LeaderboardMappingService;
import com.poe.ladder.backend.leagues.business.LeagueNameService;
	
@Service
public class LeaderboardPollingServiceImpl implements LeaderboardPollingService {		

	@Autowired
	LeagueNameService leagueNameService;

	@Autowired
	LeaderboardUrlsService leaderboardUrlsService;

	@Autowired
	LeaderboardApiRequestService leaderboardApiRequestService;	

	@Autowired
	LeaderboardApiUrlsConfig leaderboardApiUrlsConfig;
	
	@Autowired
	LeaderboardMappingService leaderboardMappingService;	

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
				mapApiResponseToEntity(apiResponseList, leagueUrl.getValue());
//				persistEntityToDb();
				sleepBeforeNextApiRequest();
			}			
		}
	}	
	
	private List<Entry> requestLeaderboardFromPoeApi(String value) {
		return leaderboardApiRequestService.requestLeaderboardFromPoeApi(value);
	}

	private void mapApiResponseToEntity(List<Entry> apiResponseList, String requestUrl) {
		leaderboardMappingService.mapApiResponseToEntity(apiResponseList, requestUrl);
	}

	private void sleepBeforeNextApiRequest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			throw new RuntimeException("sleepBeforeNextApiRequest() encountered an InterruptedException : " + ex);
		}
	}

}
