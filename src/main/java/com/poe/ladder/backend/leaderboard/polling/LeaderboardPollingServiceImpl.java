package com.poe.ladder.backend.leaderboard.polling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.external.api.requests.LeaderboardApiRequestServiceImpl;
import com.poe.ladder.backend.external.api.requests.urls.LeaderboardApiUrlsConfig;
import com.poe.ladder.backend.external.api.requests.urls.LeaderboardUrlsService;
import com.poe.ladder.backend.external.api.response.Entry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardEntryEntity;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;
import com.poe.ladder.backend.leagues.business.LeagueNameService;
	
@Service
public class LeaderboardPollingServiceImpl implements LeaderboardPollingService {	

	@Autowired
	LeagueNameService leagueNameService;

	@Autowired
	LeaderboardUrlsService leaderboardUrlsService;

	@Autowired
	LeaderboardApiRequestServiceImpl leaderboardApiRequestServiceImpl;

	@Autowired
	LeaderboardApiUrlsConfig leaderboardApiUrlsConfig;

	private List<Entry> apiResponseList;               
	private List<LeaderboardEntryEntity> leaderBoardEntityList;
	private List<Map<String, String>> leaderboardUrls;

	private LeaderboardEntryEntity leaderboardEntity;
	private LeaderboardType leaderboardType;
	
	public LeaderboardPollingServiceImpl() {
		leaderBoardEntityList = new ArrayList<>();
	}

	@PostConstruct
	public void init() throws InterruptedException {
		leaderboardUrls = leaderboardUrlsService.getLeaderboardUrls();
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
	
	private List<Entry> requestLeaderboardFromPoeApi(String value) {
		return leaderboardApiRequestServiceImpl.requestLeaderboardFromPoeApi(value);
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



	private void sleepBeforeNextApiRequest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			throw new RuntimeException("sleepBeforeNextApiRequest() encountered an InterruptedException");
		}
	}

}
