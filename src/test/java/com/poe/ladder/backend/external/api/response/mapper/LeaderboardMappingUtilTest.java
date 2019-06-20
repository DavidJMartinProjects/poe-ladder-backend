package com.poe.ladder.backend.external.api.response.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;

public class LeaderboardMappingUtilTest {
	
	@Autowired
	LeaderboardMappingUtil leaderboardMappingUtil;	

	@Test(expected=NullPointerException.class)
	public void whenMapToleaderboardEntryIsCalledWithNullleagueNameParam_thenNullPointerExceptionIsThrown() {
		String nullLeagueName = null;
		Entry entry = new Entry();		
		LeaderboardType leaderboardType = LeaderboardType.DELVE;
		String timestamp = "18:00:00";
		leaderboardMappingUtil.mapToLeaderboardEntry(nullLeagueName, leaderboardType, entry, timestamp);
	}

}
