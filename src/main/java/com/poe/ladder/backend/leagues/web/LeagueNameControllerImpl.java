package com.poe.ladder.backend.leagues.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.leaderboard.business.LeagueNameService;
import com.poe.ladder.backend.leaderboard.domain.League;

@RestController
public class LeagueNameControllerImpl implements LeagueNameController {
	
	@Autowired
	LeagueNameService leagueNameService;
	
	@GetMapping
	public String rootCheck() {
		return "Welcome to poe-ladder-db.com";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/current-leagues")
	public List<League> getCurrentLeagues() {
		return leagueNameService.getLeagueVariationNames();
	}
	
	@RequestMapping("/league-names")
	public List<League> getLeagueNames() {
		return leagueNameService.getCurrentLeagues();
	}

}
		