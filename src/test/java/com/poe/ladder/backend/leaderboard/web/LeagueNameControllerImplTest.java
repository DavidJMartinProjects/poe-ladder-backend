package com.poe.ladder.backend.leaderboard.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.poe.ladder.backend.application.PoeLadderBackendApplication;
import com.poe.ladder.backend.leaderboard.business.LeagueNameServiceImpl;
import com.poe.ladder.backend.leaderboard.domain.LeagueName;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={PoeLadderBackendApplication.class})	
@AutoConfigureMockMvc	
public class LeagueNameControllerImplTest {		
	
	private static final String HARDCORE = "Hardcore";
	private static final String STANDARD = "Standard";
	private static final String SSF_HARDCORE = "SSF Hardcore";
	private static final String SSF_STANDARD = "SSF Standard";
	private static final String SYNTHESIS_EVENT = "Synthesis Event";
	private static final String SYNTHESIS = "Synthesis";

	@InjectMocks
	LeagueNameControllerImpl leagueNameController;
	
	@Mock	
	LeagueNameServiceImpl leagueNameService;	
	
	@Autowired
    private MockMvc mockMvc;		
	
	private List<LeagueName> leagueNames;
	private List<LeagueName> currentLeagues;
	
	@Before
	public void init() {	
		MockitoAnnotations.initMocks(this);
		
		currentLeagues = new ArrayList<>();
		currentLeagues.add(new LeagueName(STANDARD));
		currentLeagues.add(new LeagueName(HARDCORE));
		currentLeagues.add(new LeagueName(SSF_STANDARD));
		currentLeagues.add(new LeagueName(SSF_HARDCORE));
		
		leagueNames = new ArrayList<>();
		leagueNames.add(new LeagueName(STANDARD));
		leagueNames.add(new LeagueName(SYNTHESIS));
		leagueNames.add(new LeagueName(SYNTHESIS_EVENT));
	}
	
	@Test
	public void whenGetRequestToleagueNames_thenTheExpectedResponseIsReturned() throws Exception {
		when(leagueNameService.getCurrentLeagues()).thenReturn(leagueNames);	
		mockMvc.perform(get("/league-names"))				
			.andExpect(jsonPath("$[0].leagueName").value(STANDARD))
			.andExpect(jsonPath("$[1].leagueName").value(SYNTHESIS))
			.andExpect(jsonPath("$[2].leagueName").value(SYNTHESIS_EVENT))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk());
	}
	
	@Test
	public void whenGetRequestToCurrentLeagues_thenTheExpectedResponseIsReturned() throws Exception {
		when(leagueNameService.getLeagueVariationNames()).thenReturn(currentLeagues);	
		mockMvc.perform(get("/current-leagues"))				
			.andExpect(jsonPath("$[0].leagueName").value(STANDARD))
			.andExpect(jsonPath("$[1].leagueName").value(HARDCORE))
			.andExpect(jsonPath("$[2].leagueName").value(SSF_STANDARD))
			.andExpect(jsonPath("$[3].leagueName").value(SSF_HARDCORE))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk());
	}	

}
	
	