package com.poe.ladder.backend.external.api.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poe.ladder.backend.external.api.requests.urls.LeaderboardApiUrlsConfig;
import com.poe.ladder.backend.external.api.requests.urls.LeaderboardUrlsService;
import com.poe.ladder.backend.external.api.response.Entry;
import com.poe.ladder.backend.external.api.response.ResponseEntry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardEntryEntity;
import com.poe.ladder.backend.leagues.business.LeagueNameService;

@Service
public class LeaderboardPollingServiceImpl implements LeaderboardPollingService {

	@Autowired
	LeagueNameService leagueNameService;

	@Autowired
	LeaderboardUrlsService leaderboardUrlsService;

	@Autowired
	HttpEntityBuilder httpEntityBuilder;	

	@Autowired
	LeaderboardApiUrlsConfig leaderboardApiUrlsConfig;

	private List<Entry> apiResponseList;               
	private List<LeaderboardEntryEntity> leaderBoardEntityList;
	private List<Map<String, String>> leaderboardUrls;

	private LeaderboardEntryEntity leaderboardEntity;
	private LeaderboardType leaderboardType;
	
	private HttpEntity<String> entity;
	private RestTemplate restTemplate;

	public LeaderboardPollingServiceImpl() {
		leaderBoardEntityList = new ArrayList<>();
	}

	@PostConstruct
	public void init() throws InterruptedException {
		leaderboardUrls = leaderboardUrlsService.getLeaderboardUrls();
		entity = httpEntityBuilder.getConfiguredHttpEntity();
		restTemplate = new RestTemplate();
		getLeaderboardRankings();
	}

	@Override
	public void getLeaderboardRankings() {
		for (Map<String, String> urlsList : leaderboardUrls) {
			for (Map.Entry<String, String> leagueUrl : urlsList.entrySet()) {
				leaderboardType = determineLeaderboardType(leagueUrl.getValue());	
				apiResponseList = requestLeaderboardFromPoeApi(leagueUrl.getValue());
				mapApiResponseToEntity(leaderboardType, apiResponseList);
//				persistEntityToDb();
				sleepBeforeNextApiRequest();
			}			
		}
	}
	
	private List<LeaderboardEntryEntity> mapApiResponseToEntity(LeaderboardType leaderboardType, List<Entry> apiResponseList) {
		leaderBoardEntityList.clear();
		leaderboardEntity = new LeaderboardEntryEntity();
		for (Entry responseEntry : apiResponseList) {
			leaderboardEntity.setRank(responseEntry.getRank().toString());
			leaderboardEntity.setCharacter(responseEntry.getCharacter().getName());
			leaderboardEntity.setAscendancy((responseEntry.getCharacter().getClass_()));
			if (leaderboardType==LeaderboardType.DELVE) {
				leaderboardEntity.setDepth(responseEntry.getCharacter().getDepth().getSolo().toString());
			} else if (leaderboardType==LeaderboardType.UBERLAB) { 
				leaderboardEntity.setTime(responseEntry.getTime());
			} else if (leaderboardType==LeaderboardType.RACETO100) { 
				leaderboardEntity.setLevel(responseEntry.getCharacter().getLevel().toString());
			}
			leaderBoardEntityList.add(leaderboardEntity);
		}
		return leaderBoardEntityList;
	}

	private LeaderboardType determineLeaderboardType(String url) {
		if (url.contains(leaderboardApiUrlsConfig.getDelve_postfix())) {
			return LeaderboardType.DELVE;
		} else if (url.contains(leaderboardApiUrlsConfig.getUberlab_postfix())) {
			return LeaderboardType.UBERLAB;
		} else if (url.contains(leaderboardApiUrlsConfig.getRaceto100_postfix())) {
			return LeaderboardType.RACETO100;
		}
		return LeaderboardType.UNKNOWN;
	}

	private List<Entry> requestLeaderboardFromPoeApi(String url)  {
		ResponseEntity<ResponseEntry> leaderboardApiRequest = restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntry.class);
		ResponseEntry leaderboardApiResponse = leaderboardApiRequest.getBody();
		System.out.println("===================");
		System.out.println("responseEntries : ");
		System.out.println("===================");
		List<Entry> leaderboardEntries = leaderboardApiResponse.getEntries();
		leaderboardEntries.forEach(e -> System.out.println(e));				
		return leaderboardEntries;
	}

	private void sleepBeforeNextApiRequest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			throw new RuntimeException("pauseBeforeNextApiRequest() encountered an InterruptedException");
		}
	}

}
