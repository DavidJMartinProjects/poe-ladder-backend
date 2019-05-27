package com.poe.ladder.backend.leagues.web;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.poe.ladder.backend.application.PoeLadderBackendApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={PoeLadderBackendApplication.class})
@AutoConfigureMockMvc	
public class LeagueNameControllerImplTest {
	
    @Autowired	
    private MockMvc mockMvc;	
	
	@Test
	public void whenGetRequestToCurrentLeagues_ThenTheExpectedStatusCodeIsReturned() throws Exception {
		this.mockMvc.perform(get("/current-leagues"))
		.andExpect(status().isOk());		
	}
	
	@Test
	public void whenGetRequestToCurrentLeagues_ThenTheExpectedNumberOfLeagueNamesAreReturned() throws Exception {
		this.mockMvc.perform(get("/current-leagues"))
		.andExpect(jsonPath("$", hasSize(12)));			
	}
	
	@Test
	public void whenGetRequestToCurrentLeagues_ThenTheExpectedDefaultLeagueNamesAreReturned() throws Exception {
		this.mockMvc.perform(get("/current-leagues"))
		.andExpect(jsonPath("$[0].leagueName").value("Standard"))
		.andExpect(jsonPath("$[1].leagueName").value("Hardcore"))
		.andExpect(jsonPath("$[2].leagueName").value("SSF Standard"))
		.andExpect(jsonPath("$[3].leagueName").value("SSF Hardcore"));
	}
	
}	
