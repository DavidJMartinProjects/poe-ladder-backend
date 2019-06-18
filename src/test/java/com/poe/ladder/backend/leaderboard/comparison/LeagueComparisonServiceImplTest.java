package com.poe.ladder.backend.leaderboard.comparison;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.ladder.backend.application.PoeLadderBackendApplication;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardType;
import com.poe.ladder.backend.leaderboard.repository.entity.LeaderBoardEntity;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = PoeLadderBackendApplication.class)	
public class LeagueComparisonServiceImplTest {
	
	private static final String TEST_LEADERBOARD = LeaderboardType.RACETO100.toString();
	private static final String TEST_LEAGUE_NAME = "test_leagueName";
	private static final String TEST_CHARACTER_ID = "abc_123";
	private static final String TEST_CHARACTER_NAME = "test_characterName";
	private static final String TEST_ACCOUNT_NAME = "test_accountName";
	private static final String TEST_ASCENDANCY = "shadow";

	@Autowired
	LeagueComparisonService leagueComparisonService;
	
	List<LeaderBoardEntity> oldLeagueEntryList;
	List<LeaderBoardEntity> newLeagueEntryList;	
	LeaderBoardEntity oldLeagueEntry;
	LeaderBoardEntity newLeagueEntry;
	
	Logger logger = LoggerFactory.getLogger(LeagueComparisonServiceImplTest.class);
	
	@Before
	public void init() {
		oldLeagueEntryList = new ArrayList<>();
		newLeagueEntryList = new ArrayList<>();	
		oldLeagueEntry = new LeaderBoardEntity();
		newLeagueEntry = new LeaderBoardEntity();
		
		oldLeagueEntry.setAccount(TEST_ACCOUNT_NAME);
		oldLeagueEntry.setAscendancy(TEST_ASCENDANCY);
		oldLeagueEntry.setCharacter(TEST_CHARACTER_NAME);
		oldLeagueEntry.setCharacterId(TEST_CHARACTER_ID);
		oldLeagueEntry.setLeague(TEST_LEAGUE_NAME);
		oldLeagueEntry.setLeaderboard(TEST_LEADERBOARD);
		oldLeagueEntry.setRank("10");		
		oldLeagueEntry.setExperience("100,000,000");	
		oldLeagueEntryList.add(oldLeagueEntry);
		
		newLeagueEntry.setAccount(TEST_ACCOUNT_NAME);
		newLeagueEntry.setAscendancy(TEST_ASCENDANCY);
		newLeagueEntry.setCharacter(TEST_CHARACTER_NAME);
		newLeagueEntry.setCharacterId(TEST_CHARACTER_ID);
		newLeagueEntry.setLeague(TEST_LEAGUE_NAME);
		newLeagueEntry.setLeaderboard(TEST_LEADERBOARD);
		newLeagueEntry.setRank("8");			
		newLeagueEntry.setExperience("100,200,000");	
		newLeagueEntryList.add(newLeagueEntry);
	}
	
	@Test
	public void whenCompareLeagueIsCalled_ThenTheExpectedCharacterRankDifferenceIsDetermined() {	
		List<LeaderBoardEntity> leagueComparisonResults = leagueComparisonService.compareLeague(oldLeagueEntryList, newLeagueEntryList);
		assertEquals("+2", leagueComparisonResults.get(0).getRankDifference());		
	}
	
	@Test
	public void whenCompareLeagueIsCalled_ThenTheExpectedCharacterExperienceDifferenceIsDetermined() {	
		List<LeaderBoardEntity> leagueComparisonResults = leagueComparisonService.compareLeague(oldLeagueEntryList, newLeagueEntryList);	
		assertEquals("0.20M", leagueComparisonResults.get(0).getExperienceDifference());
	}

}
