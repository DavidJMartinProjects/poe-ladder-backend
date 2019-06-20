package com.poe.ladder.backend.leagues.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.ladder.backend.application.PoeLadderBackendApplication;
import com.poe.ladder.backend.leaderboard.business.LeagueNameService;	
import com.poe.ladder.backend.leaderboard.domain.LeagueName;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = PoeLadderBackendApplication.class)		
public class LeagueNameServiceImplTest {
	
	private static final String SYNTHESIS = "Synthesis";
	
	@Autowired
	LeagueNameService leagueNameService;
	
	@Test
	public void whenGetLeagueVariationsByleagueNameIsRequested_thenTheExpectedResultsAreReturned() {
		List<String> foundLeagueVariations = leagueNameService.getLeagueVariationsListByLeagueName(SYNTHESIS);
		assertEquals(SYNTHESIS, foundLeagueVariations.get(0));
		assertEquals("Hardcore Synthesis", foundLeagueVariations.get(1));
		assertEquals("SSF Synthesis", foundLeagueVariations.get(2));
		assertEquals("SSF Synthesis HC", foundLeagueVariations.get(3));	
	}
	
	@Test
	public void whenGetCurrentLeaguesIsRequested_thenTheExpectedResultsAreReturned() {
		List<LeagueName> leagueNames = leagueNameService.getCurrentLeagues();	
		assertEquals(new LeagueName("Standard"), leagueNames.get(0));
		assertEquals(new LeagueName(SYNTHESIS), leagueNames.get(1));
		assertEquals(new LeagueName("Synthesis Event"), leagueNames.get(2));
	}
	
	@Test
	public void whenGetLeagueVariationNamesIsRequested_thenTheExpectedResultsAreReturned() {
		List<LeagueName> expectedLeagueNames = new ArrayList<>();
		expectedLeagueNames.add(new LeagueName("Standard"));
		expectedLeagueNames.add(new LeagueName("Hardcore"));
		expectedLeagueNames.add(new LeagueName("SSF Standard"));
		expectedLeagueNames.add(new LeagueName("SSF Hardcore"));
		expectedLeagueNames.add(new LeagueName(SYNTHESIS));
		expectedLeagueNames.add(new LeagueName("Hardcore Synthesis"));
		expectedLeagueNames.add(new LeagueName("SSF Synthesis"));
		expectedLeagueNames.add(new LeagueName("SSF Synthesis HC"));
		expectedLeagueNames.add(new LeagueName("Synthesis Event (SRE001)"));
		expectedLeagueNames.add(new LeagueName("Synthesis Event HC (SRE002)"));
		expectedLeagueNames.add(new LeagueName("SSF Synthesis Event (SRE003)"));
		expectedLeagueNames.add(new LeagueName("SSF Synthesis Event HC (SRE004)"));
		
		List<LeagueName> actualLeagueNames = leagueNameService.getLeagueVariationNames();	
		
		for (int i = 0; i < actualLeagueNames.size(); i++) {
			assertEquals(expectedLeagueNames.get(i), actualLeagueNames.get(i));
		}
	}

}
