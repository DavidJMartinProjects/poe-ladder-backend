package com.poe.ladder.backend.external.api.response.mapper;

import java.util.List;

import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

public interface LeaderboardMappingService {
	List<LeaderBoardEntity> mapApiResponseToEntity(List<Entry> apiResponseList, String requestUrl, String leagueName, String timestamp);
}
		