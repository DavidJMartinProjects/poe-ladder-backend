package com.poe.ladder.backend.leagues.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.ladder.backend.application.PoeLadderBackendApplication;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = PoeLadderBackendApplication.class)		
public class LeagueVariationsConfigTest {
	
	@Autowired
	LeagueVariationsConfig leagueVariationsConfig;

	@Test
	public void test() {
		System.out.println("leagueVariationsConfig : " + leagueVariationsConfig.getLeagueVariations());
	}

}	
