package com.poe.ladder.backend.leaderboard.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
		currentLeagues.add(new LeagueName(Constants.STANDARD));
		currentLeagues.add(new LeagueName(Constants.HARDCORE));
		currentLeagues.add(new LeagueName(Constants.SSF_STANDARD));	
		currentLeagues.add(new LeagueName(Constants.SSF_HARDCORE));
		
		leagueNames = new ArrayList<>();
		leagueNames.add(new LeagueName(Constants.STANDARD));
		leagueNames.add(new LeagueName(Constants.SYNTHESIS));
		leagueNames.add(new LeagueName(Constants.SYNTHESIS_EVENT));
	}
	
	@Test
	public void whenGetRequestToleagueNames_thenTheExpectedResponseIsReturned() throws Exception {
		when(leagueNameService.getCurrentLeagues()).thenReturn(leagueNames);	
		mockMvc.perform(get("/league-names"))				
			.andExpect(jsonPath("$[0].leagueName").value(Constants.STANDARD))
			.andExpect(jsonPath("$[1].leagueName").value(Constants.SYNTHESIS))
			.andExpect(jsonPath("$[2].leagueName").value(Constants.SYNTHESIS_EVENT))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk());
	}
	
	@Test
	public void whenGetRequestToCurrentLeagues_thenTheExpectedResponseIsReturned() throws Exception {
		when(leagueNameService.getLeagueVariationNames()).thenReturn(currentLeagues);	
		mockMvc.perform(get("/current-leagues"))				
			.andExpect(jsonPath("$[0].leagueName").value(Constants.STANDARD))
			.andExpect(jsonPath("$[1].leagueName").value(Constants.HARDCORE))
			.andExpect(jsonPath("$[2].leagueName").value(Constants.SSF_STANDARD))
			.andExpect(jsonPath("$[3].leagueName").value(Constants.SSF_HARDCORE))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk());
	}	

}
	
	