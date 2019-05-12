package com.poe.ladder.backend.external.api.response.mapper;

import java.util.List;

import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

public interface LeaderboardMappingService {
	List<LeaderBoardEntry> mapApiResponseToEntity(List<Entry> apiResponseList, String requestUrl, String leagueName);
}
		