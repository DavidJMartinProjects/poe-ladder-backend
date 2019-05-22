package com.poe.ladder.backend.leagues.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.poe.ladder.backend.external.api.requests.LeaderboardApiRequestService;
import com.poe.ladder.backend.external.api.requests.urls.LeaderboardUrlsService;
import com.poe.ladder.backend.external.api.response.mapper.LeaderboardMappingServiceImpl;
import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomLeagueServiceImplTest {
	
	private static final String WWW_URL_COM = "www.url.com";
	private static final String CUSTOM_LEAGUE_NAME = "custom_league_name";
	private static final int _3 = 3;

	@Mock
	LeaderboardApiRequestService leaderboardApiRequestService;

	@Mock
	LeaderboardUrlsService leaderboardUrlsService;

	@Mock
	LeaderboardMappingServiceImpl leaderboardMappingServiceImpl;

	@InjectMocks
	CustomLeagueServiceImpl customLeagueServiceImpl;

	private LeaderBoardEntryTestUtil leaderBoardEntryTestUtil = new LeaderBoardEntryTestUtil();
	private EntryTestUtil entryTestUtil = new EntryTestUtil();

	@Before
	public void init() {		
		when(leaderboardUrlsService.getCustomLeagueUrl()).thenReturn(new String(WWW_URL_COM));		
		when(leaderboardApiRequestService.requestLeaderboardFromPoeApi(anyString())).thenReturn(entryTestUtil.getEntries());				
		when(leaderboardMappingServiceImpl.mapApiResponseToEntity(anyList(), anyString(), anyString())).thenReturn(leaderBoardEntryTestUtil.getLeaderboardEntries());
	}
	
	@Test		
	public void whenGetCustomLeagueleaderboardIsCalled_thenTheExpectedNumberOfLeaderboardResultsAreReturned() {	
		assertEquals(_3, customLeagueServiceImpl.getCustomLeagueLeaderboard(CUSTOM_LEAGUE_NAME).size());		
	}
	
	@Test		
	public void whenGetCustomLeagueleaderboardIsCalled_thenTheExpectedLeaderboardResultsAreReturned() {	
		List<LeaderBoardEntry> actualLeaderboardEntries = customLeagueServiceImpl.getCustomLeagueLeaderboard(CUSTOM_LEAGUE_NAME);
		List<LeaderBoardEntry> expectedLeaderboardEntries = leaderBoardEntryTestUtil.getLeaderboardEntries();	
		for (int i = 0; i < actualLeaderboardEntries.size(); i++) {
			verifyLeaderboardEntriesAreIdentical(expectedLeaderboardEntries.get(0), actualLeaderboardEntries.get(0));			
		}		
	}
	
	public void verifyLeaderboardEntriesAreIdentical(LeaderBoardEntry expectedLeaderBoardEntry, LeaderBoardEntry actualLeaderBoardEntry) {		
		assertEquals(expectedLeaderBoardEntry.getAscendancy(), actualLeaderBoardEntry.getAscendancy());
		assertEquals(expectedLeaderBoardEntry.getCharacter(), actualLeaderBoardEntry.getCharacter());		
		assertEquals(expectedLeaderBoardEntry.getDead(), actualLeaderBoardEntry.getDead());		
		assertEquals(expectedLeaderBoardEntry.getExperience(), actualLeaderBoardEntry.getExperience());
		assertEquals(expectedLeaderBoardEntry.getLeaderboard(), actualLeaderBoardEntry.getLeaderboard());
		assertEquals(expectedLeaderBoardEntry.getLeague(), actualLeaderBoardEntry.getLeague());
		assertEquals(expectedLeaderBoardEntry.getLevel(), actualLeaderBoardEntry.getLevel());
		assertEquals(expectedLeaderBoardEntry.getLevel(), actualLeaderBoardEntry.getLevel());
		assertEquals(expectedLeaderBoardEntry.getOnline(), actualLeaderBoardEntry.getOnline());
		assertEquals(expectedLeaderBoardEntry.getProgress(), actualLeaderBoardEntry.getProgress());
		assertEquals(expectedLeaderBoardEntry.getRank(), actualLeaderBoardEntry.getRank());
	}

}
