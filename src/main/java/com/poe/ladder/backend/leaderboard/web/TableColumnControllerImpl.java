package com.poe.ladder.backend.leaderboard.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.leaderboard.business.TableColumnsService;

@RestController
public class TableColumnControllerImpl implements TableColumnController {
	
	@Autowired
	TableColumnsService dataTableColumnsService;

	@GetMapping("leaderboard-columns-delve")
	public List<TableColumn> getDelveTableColumns() {		
		return dataTableColumnsService.getDelveTableColumns();
	}
	
	@GetMapping("leaderboard-columns-uberlab")
	public List<TableColumn> getUberLabTableColumns() {		
		return dataTableColumnsService.getUberLabTableColumns();
	}
	
	@GetMapping("leaderboard-columns-raceto100")
	public List<TableColumn> getRaceTo100TableColumns() {		
		return dataTableColumnsService.getRaceTo100TableColumns();
	}

}	
