package com.poe.ladder.backend.leaderboard.table.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.table.config.DelveTableColumnConfig;
import com.poe.ladder.backend.leaderboard.table.config.RaceTableColumnConfig;
import com.poe.ladder.backend.leaderboard.table.config.UberLabTableColumnConfig;

@Service
public class TableColumnsServiceImpl implements TableColumnsService {
	
	@Autowired
	DelveTableColumnConfig delveTableColumnConfig;
	
	@Autowired
	RaceTableColumnConfig raceTableColumnConfig;
	
	@Autowired
	UberLabTableColumnConfig uberLabTableColumnConfig;

	@Override
	public List<String> getDelveTableColumns() {
		return delveTableColumnConfig.getTableColumns();
	}

	@Override
	public List<String> getRaceTo100TableColumns() {
		return raceTableColumnConfig.getTableColumns();
	}

	@Override
	public List<String> getUberLabTableColumns() {
		return uberLabTableColumnConfig.getTableColumns();
	}	

}	
