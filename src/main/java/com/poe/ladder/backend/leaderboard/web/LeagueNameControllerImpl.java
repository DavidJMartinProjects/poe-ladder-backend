package com.poe.ladder.backend.leaderboard.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.leaderboard.business.LeagueNameService;
import com.poe.ladder.backend.leaderboard.domain.LeagueName;

@RestController
public class LeagueNameControllerImpl implements LeagueNameController {
	
	@Autowired
	LeagueNameService leagueNameService;
	
	@GetMapping
	public String rootCheck() {
		return "Welcome to poe-ladder-db.com";
	}

	@RequestMapping("/current-leagues")
	public List<LeagueName> getLeagueVariationNames() {
		return leagueNameService.getLeagueVariationNames();
	}
	
	@RequestMapping("/league-names")
	public List<LeagueName> getCurrentLeagues() {
		return leagueNameService.getCurrentLeagues();
	}

}
			