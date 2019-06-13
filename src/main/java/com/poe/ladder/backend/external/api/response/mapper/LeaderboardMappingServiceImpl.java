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
import com.poe.ladder.backend.leaderboard.progressbar.ProgressBarService;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;
import com.poe.ladder.backend.util.MappingUtil;

@Component
public class LeaderboardMappingServiceImpl implements LeaderboardMappingService {

	@Autowired
	LeaderboardApiUrlsConfig leaderboardApiUrlsConfig;

	@Autowired
	LeagueNameService leagueNameService;
	
	@Autowired
	ProgressBarService progressBarService;

	@Autowired
	MappingUtil formatUtil;

	private List<LeaderBoardEntity> leaderBoardEntityList;	
	
	private static final Logger LOG = LoggerFactory.getLogger(LeaderboardMappingServiceImpl.class);

	public LeaderboardMappingServiceImpl() {
		leaderBoardEntityList = new ArrayList<>();
	}

	public List<LeaderBoardEntity> mapApiResponseToEntity(List<Entry> apiResponseList, String requestUrl, String leagueName, String timestamp) {
		LOG.info("mapApiResponseToEntity(): request received to map api response to leaderboard entity");
		leaderBoardEntityList.clear();		
		LeaderboardType leaderboardType = determineLeaderboardType(requestUrl);
		for (Entry responseEntry : apiResponseList) {
			LeaderBoardEntity leaderboardEntity = mapToLeaderboardEntry(leagueName, leaderboardType, responseEntry, timestamp);
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
	
	private LeaderBoardEntity mapToLeaderboardEntry(String leagueName, LeaderboardType leaderboardType, Entry responseEntry, String timestamp) {
		LeaderBoardEntity leaderboardEntity = new LeaderBoardEntity();
		leaderboardEntity.setTimeStamp(timestamp);
		leaderboardEntity.setLeague(leagueName);
		leaderboardEntity.setLeaderboard(leaderboardType.toString());
		leaderboardEntity.setRank(responseEntry.getRank().toString());
		leaderboardEntity.setRankDifference("0");
		leaderboardEntity.setCharacterId(responseEntry.getCharacter().getId());
		leaderboardEntity.setCharacter(responseEntry.getCharacter().getName());
		leaderboardEntity.setAccount(responseEntry.getAccount().getName());
		leaderboardEntity.setOnline(responseEntry.getOnline().toString());
		leaderboardEntity.setAscendancy((responseEntry.getCharacter().getClass_()));
		mapLeagueSpecificFields(leaderboardType, responseEntry, leaderboardEntity);
		return leaderboardEntity;
	}

	private void mapLeagueSpecificFields(LeaderboardType leaderboardType, Entry responseEntry, LeaderBoardEntity leaderboardEntity) {
		if (leaderboardType == LeaderboardType.DELVE) {
			leaderboardEntity.setDepth(responseEntry.getCharacter().getDepth().getSolo().toString());
			leaderboardEntity.setDead(responseEntry.getDead().toString());
		} else if (leaderboardType == LeaderboardType.UBERLAB) {
			leaderboardEntity.setTime(responseEntry.getTime());
			leaderboardEntity.setTimeFormatted(responseEntry.getTime());
		} else if(leaderboardType == LeaderboardType.RACETO100) {				
			leaderboardEntity.setDead(responseEntry.getDead().toString());
			leaderboardEntity.setLevel(responseEntry.getCharacter().getLevel().toString());
			String experience = responseEntry.getCharacter().getExperience().toString();
			String level = leaderboardEntity.getLevel();
			String levelProgress = progressBarService.getProgressPercentage(level, experience);
			leaderboardEntity.setProgress(levelProgress);
			String formattedXp = formatExperience(experience);
			leaderboardEntity.setExperience(formattedXp);
		}
	}

	private String formatExperience(String xp) {
		return MappingUtil.formatStringToDouble(xp);
	}	
	
}
