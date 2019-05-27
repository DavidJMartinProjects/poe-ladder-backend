package com.poe.ladder.backend.external.api.requests.urls;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.poe.ladder.backend.leaderboard.domain.LeagueName;
import com.poe.ladder.backend.leagues.business.LeagueNameService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LeaderboardUrlBuilderTest {
	
	@Mock
	LeagueNameService leagueNameService;
	
	@Mock
	LeaderboardApiUrlsConfig urlsConfig;
	
	@InjectMocks
	LeaderboardUrlBuilder leaderboardUrlBuilder;
	
	private String expectedLeagueName = "Synthesis";
	private String expectedDelveLeagueUrlPrefix = "http://www.pathofexile.com/api/ladders?offset=0&limit=100&id=";
	private String expectedDelveLeagueUrlPostfix = "&type=league&sort=depthsolo&_=1546137921952";
	
	private Map<String, String> expectedDelveUrls = new HashMap<>();	
	private Map<String, String> expectedUberLabUrls = new HashMap<>();
	private Map<String, String> expectedRaceTo100Urls = new HashMap<>();	
	
	@Before
	public void init() {
		LeagueName[] names = {new LeagueName("Synthesis")};		
//		when(urlsConfig.getDelvePrefix()).thenReturn(new String(expectedDelveLeagueUrlPrefix));
//		when(urlsConfig.getDelvePrefix()).thenReturn(new String(expectedDelveLeagueUrlPrefix));
//		when(leagueNameService.getLeagueVariationNames()).thenReturn(Arrays.asList(names));		
	}	
	
	@Test
	public void whenBuildUrlsIsCalled_ThenTheExpectedUrlsAreConstructed() {
//		expectedLeagueName = "Synthesis";
//		expectedDelveLeagueUrlPrefix = "http://www.pathofexile.com/api/ladders?offset=0&limit=100&id=";
//		expectedDelveLeagueUrlPostfix = "&type=league&sort=depthsolo&_=1546137921952";
//		String expectedDelveUrl = expectedDelveLeagueUrlPrefix + expectedLeagueName + expectedDelveLeagueUrlPostfix;
//		expectedDelveUrls.put(expectedLeagueName, expectedDelveUrl);
//		List<Map<String, String>> actualLeagueUrlsList = leaderboardUrlBuilder.getLeaderBoardUrls();
//		String actualDelveUrl = actualLeagueUrlsList.get(0).get("Synthesis");
//		System.out.println("actualLeagueUrlsList.size() : " + actualLeagueUrlsList.size());
//		System.out.println("actualLeagueUrlsList.get(0) : " + actualLeagueUrlsList);
//		assertEquals(expectedDelveUrl, actualDelveUrl);
	}
	
//    delvePrefix: http://www.pathofexile.com/api/ladders?offset=0&limit=${urls.properties.resultsLimit}&id=
//    delvePostfix: '&type=league&sort=depthsolo&_=1546137921952'  

}
			