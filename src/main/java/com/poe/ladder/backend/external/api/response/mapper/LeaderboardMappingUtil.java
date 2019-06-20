package com.poe.ladder.backend.external.api.response.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;
import com.poe.ladder.backend.leaderboard.progressbar.ProgressBarService;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;
import com.poe.ladder.backend.util.FormattingUtils;

import lombok.NonNull;

@Component
public class LeaderboardMappingUtil {
	
	@Autowired
	ProgressBarService progressBarService;		
	
	public LeaderBoardEntity mapToLeaderboardEntry(@NonNull String leagueName, @NonNull LeaderboardType leaderboardType, @NonNull Entry responseEntry, @NonNull String timestamp) {
		
		LeaderBoardEntity leaderboardEntity = LeaderBoardEntity.builder()
			.character(responseEntry.getCharacter().getName())
			.account(responseEntry.getAccount().getName())
			.online(responseEntry.getOnline().toString())
			.ascendancy(responseEntry.getCharacter().getClass_())
			.timeStamp(timestamp)
			.league(leagueName)
			.leaderboard(leaderboardType.getValue())
			.rank(responseEntry.getRank().toString())
			.rankDifference("0")
			.experienceDifference("0")
			.characterId(responseEntry.getCharacter().getId())
			.build();
		
		mapLeagueSpecificFields(leaderboardType, responseEntry, leaderboardEntity);
		return leaderboardEntity;
	}

	public void mapLeagueSpecificFields(@NonNull LeaderboardType leaderboardType, @NonNull Entry responseEntry, @NonNull LeaderBoardEntity leaderboardEntity) {
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

	private String formatExperience(@NonNull String xp) {
		return FormattingUtils.formatStringToDouble(xp);
	}

}
