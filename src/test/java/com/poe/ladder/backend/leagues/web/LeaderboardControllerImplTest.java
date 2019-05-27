package com.poe.ladder.backend.leagues.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
public class LeaderboardControllerImplTest {

    @Autowired	
    private MockMvc mockMvc;
    
    private String leagueName = "Synthesis";
    private String leaderboard = "Top Delve Depths";
    
	@Test
	public void whenGetRequestToleaderboardsUrl_ThenTheExpectedStatusCodeIsReturned() throws Exception {
		this.mockMvc.perform(get("/leaderboards" + "?leagueName=" +leagueName+ "&leaderboard=" +leaderboard))
		.andExpect(status().isOk());		
	}

}
	