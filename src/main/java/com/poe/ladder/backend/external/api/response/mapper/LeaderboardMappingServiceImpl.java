package com.poe.ladder.backend.external.api.response.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poe.ladder.backend.external.api.requests.urls.LeaderboardApiUrlsConfig;
import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardEntryEntity;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;

@Component
public class LeaderboardMappingServiceImpl implements LeaderboardMappingService {
	
	@Autowired
	LeaderboardApiUrlsConfig leaderboardApiUrlsConfig;	
	
	private List<LeaderboardEntryEntity> leaderBoardEntityList;
	private LeaderboardEntryEntity leaderboardEntity;
	
	public LeaderboardMappingServiceImpl() {
		leaderBoardEntityList = new ArrayList<>();
	}
	
	public List<LeaderboardEntryEntity> mapApiResponseToEntity(List<Entry> apiResponseList, String requestUrl) {
		leaderBoardEntityList.clear();
		leaderboardEntity = new LeaderboardEntryEntity();
		LeaderboardType leaderboardType = determineLeaderboardType(requestUrl);
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
