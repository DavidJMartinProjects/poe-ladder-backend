package com.poe.ladder.backend.external.api.response.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poe.ladder.backend.external.api.requests.urls.LeaderboardApiUrlsConfig;
import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;
import com.poe.ladder.backend.leagues.business.LeagueNameService;

@Component
public class LeaderboardMappingServiceImpl implements LeaderboardMappingService {

	@Autowired
	LeaderboardApiUrlsConfig leaderboardApiUrlsConfig;

	@Autowired
	LeagueNameService leagueNameService;

	private List<LeaderBoardEntry> leaderBoardEntityList;
	private LeaderBoardEntry leaderboardEntity;

	public LeaderboardMappingServiceImpl() {
		leaderBoardEntityList = new ArrayList<>();
	}

	public List<LeaderBoardEntry> mapApiResponseToEntity(List<Entry> apiResponseList, String requestUrl, String leagueName) {
		leaderBoardEntityList = new ArrayList<>();		
		LeaderboardType leaderboardType = determineLeaderboardType(requestUrl);
		System.out.println("mapApiResponseToEntity().apiResponseList.size : " + apiResponseList.size());
		for (Entry responseEntry : apiResponseList) {
			leaderboardEntity = new LeaderBoardEntry();
			leaderboardEntity.setLeague(leagueName);
			leaderboardEntity.setLeaderboard(leaderboardType.toString());
			leaderboardEntity.setRank(responseEntry.getRank().toString());
			leaderboardEntity.setCharacter(responseEntry.getCharacter().getName());
			leaderboardEntity.setAscendancy((responseEntry.getCharacter().getClass_()));
			if (leaderboardType == LeaderboardType.DELVE) {
				leaderboardEntity.setDepth(responseEntry.getCharacter().getDepth().getSolo().toString());
			} else if (leaderboardType == LeaderboardType.UBERLAB) {
				leaderboardEntity.setTime(responseEntry.getTime());
			} else if (leaderboardType == LeaderboardType.RACETO100) {
				leaderboardEntity.setLevel(responseEntry.getCharacter().getLevel().toString());
			}
			leaderBoardEntityList.add(leaderboardEntity);
		}
		System.out.println("mapApiResponseToEntity().leaderBoardEntityList.size : " + apiResponseList.size());
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
