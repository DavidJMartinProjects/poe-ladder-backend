package com.poe.ladder.backend.leaderboard.comparison;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.ladder.backend.application.PoeLadderBackendApplication;
import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = PoeLadderBackendApplication.class)	
public class LeagueComparisonServiceImplTest {
	
	private static final String TEST_CHARACTER_ID = "abc_123";
	private static final String TEST_CHARACTER_NAME = "test_characterName";
	private static final String TEST_ACCOUNT_NAME = "test_accountName";
	private static final String TEST_ASCENDANCY = "shadow";

	@Autowired
	LeagueComparisonService leagueComparisonService;
	
	LeaderBoardEntry oldLeagueEntry = new LeaderBoardEntry();
	LeaderBoardEntry newLeagueEntry = new LeaderBoardEntry();
	
	List<LeaderBoardEntry> oldLeagueEntryList = new ArrayList<>();
	List<LeaderBoardEntry> newLeagueEntryList = new ArrayList<>();
	
	@Before
	public void init() {
		oldLeagueEntry.setAccount(TEST_ACCOUNT_NAME);
		oldLeagueEntry.setAscendancy(TEST_ASCENDANCY);
		oldLeagueEntry.setCharacter(TEST_CHARACTER_NAME);
		oldLeagueEntry.setCharacterId(TEST_CHARACTER_ID);
		oldLeagueEntry.setRank("10");		
		oldLeagueEntry.setExperience("100,000,000");	
		oldLeagueEntryList.add(oldLeagueEntry);
		
		newLeagueEntry.setAccount(TEST_ACCOUNT_NAME);
		newLeagueEntry.setAscendancy(TEST_ASCENDANCY);
		newLeagueEntry.setCharacter(TEST_CHARACTER_NAME);
		newLeagueEntry.setCharacterId(TEST_CHARACTER_ID);
		newLeagueEntry.setRank("8");		
		newLeagueEntry.setExperience("100,200,000");	
		newLeagueEntryList.add(newLeagueEntry);
	}
	
	@Test
	public void whenCompareLeagueIsCalled_ThenTheExpectedCharacterRankDifferenceIsDetermined() {	
		List<LeaderBoardEntry> comparedLeague = leagueComparisonService.compareLeague(oldLeagueEntryList, newLeagueEntryList);
		assertEquals("2", comparedLeague.get(0).getRankDifference());		
	}
	
	@Test
	public void whenCompareLeagueIsCalled_ThenTheExpectedCharacterExperienceDifferenceIsDetermined() {	
		List<LeaderBoardEntry> comparedLeague = leagueComparisonService.compareLeague(oldLeagueEntryList, newLeagueEntryList);		
		assertEquals("200000", comparedLeague.get(0).getExperienceDifference());
	}

}
