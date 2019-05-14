package com.poe.ladder.backend.leagues.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poe.ladder.backend.application.PoeLadderBackendApplication;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = PoeLadderBackendApplication.class)		
public class LeagueNameServiceImplTest {
	
	@Autowired
	LeagueNameService leagueNameService;

	@Test
	public void getLeagueVariationsListByLeagueNameTest() {
		String leagueName = "Synthesis";
		List<String> foundLeagueVariations = new ArrayList<String>();
		foundLeagueVariations = leagueNameService.getLeagueVariationsListByLeagueName(leagueName);
		System.out.println("foundLeagueVariations : " + foundLeagueVariations);
	}

}
