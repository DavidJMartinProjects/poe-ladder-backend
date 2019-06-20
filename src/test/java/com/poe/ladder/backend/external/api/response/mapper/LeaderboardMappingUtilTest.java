package com.poe.ladder.backend.external.api.response.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;

public class LeaderboardMappingUtilTest {
	
	@Autowired
	LeaderboardMappingUtil leaderboardMappingUtil;	
	
	private String LeagueName = "Synthesis";
	private Entry entry = new Entry();		
	private LeaderboardType leaderboardType = LeaderboardType.DELVE;
	private String timestamp = "18:00:00";

	@Test(expected=NullPointerException.class)
	public void whenMapToleaderboardEntryIsCalledWithNullleagueNameParam_thenNullPointerExceptionIsThrown() {
		leaderboardMappingUtil.mapToLeaderboardEntry(null, leaderboardType, entry, timestamp);
	}
	
	@Test(expected=NullPointerException.class)
	public void whenMapToleaderboardEntryIsCalledWithNullLeaderboardTypeParam_thenNullPointerExceptionIsThrown() {
		leaderboardMappingUtil.mapToLeaderboardEntry(LeagueName, null, entry, timestamp);
	}
	
	@Test(expected=NullPointerException.class)
	public void whenMapToleaderboardEntryIsCalledWithNullEntryParam_thenNullPointerExceptionIsThrown() {
		leaderboardMappingUtil.mapToLeaderboardEntry(LeagueName, leaderboardType, null, timestamp);
	}
	
	@Test(expected=NullPointerException.class)
	public void whenMapToleaderboardEntryIsCalledWithNullTimestampParam_thenNullPointerExceptionIsThrown() {
		leaderboardMappingUtil.mapToLeaderboardEntry(LeagueName, leaderboardType, entry, null);
	}

}
