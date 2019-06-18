package com.poe.ladder.backend.external.api.response.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;
import com.poe.ladder.backend.leaderboard.progressbar.ProgressBarService;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;
import com.poe.ladder.backend.util.FormattingUtils;

@Component
public class LeaderboardMappingUtil {
	
	@Autowired
	ProgressBarService progressBarService;		
	
	public LeaderBoardEntity mapToLeaderboardEntry(String leagueName, LeaderboardType leaderboardType, Entry responseEntry, String timestamp) {
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

	public void mapLeagueSpecificFields(LeaderboardType leaderboardType, Entry responseEntry, LeaderBoardEntity leaderboardEntity) {
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
		return FormattingUtils.formatStringToDouble(xp);
	}

}
