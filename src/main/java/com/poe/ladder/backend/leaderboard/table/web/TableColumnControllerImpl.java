package com.poe.ladder.backend.leaderboard.table.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.leaderboard.table.business.TableColumnsService;

@RestController
public class TableColumnControllerImpl implements TableColumnController {
	
	@Autowired
	TableColumnsService dataTableColumnsService;

	@GetMapping("leaderboard-columns-delve")
	public List<String> getDelveTableColumns() {		
		return dataTableColumnsService.getDelveTableColumns();
	}
	
	@GetMapping("leaderboard-columns-uberlab")
	public List<String> getUberLabTableColumns() {		
		return dataTableColumnsService.getUberLabTableColumns();
	}
	
	@GetMapping("leaderboard-columns-raceto100")
	public List<String> getRaceTo100TableColumns() {		
		return dataTableColumnsService.getRaceTo100TableColumns();
	}

}	
