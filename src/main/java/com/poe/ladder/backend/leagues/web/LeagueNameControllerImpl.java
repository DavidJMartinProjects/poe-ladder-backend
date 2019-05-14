package com.poe.ladder.backend.leagues.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.leaderboard.domain.LeagueName;
import com.poe.ladder.backend.leagues.business.LeagueNameService;

@RestController
public class LeagueNameControllerImpl implements LeagueNameController {
	
	@Autowired
	LeagueNameService leagueNameService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/current-leagues")
	public List<LeagueName> getCurrentLeagues() {
		return leagueNameService.getLeagueVariationNames();		
		
		
	}
	
	@RequestMapping("/league-names")
	public List<LeagueName> getLeagueNames() {	
		return leagueNameService.getCurrentLeagues();
	}

}
		