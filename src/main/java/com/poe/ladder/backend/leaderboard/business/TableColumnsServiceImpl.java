package com.poe.ladder.backend.leaderboard.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.leaderboard.config.DelveTableColumnConfig;
import com.poe.ladder.backend.leaderboard.config.RaceTableColumnConfig;
import com.poe.ladder.backend.leaderboard.config.UberLabTableColumnConfig;
import com.poe.ladder.backend.leaderboard.web.TableColumn;

@Service
public class TableColumnsServiceImpl implements TableColumnsService {
	
	@Autowired
	DelveTableColumnConfig delveTableColumnConfig;
	
	@Autowired
	RaceTableColumnConfig raceTableColumnConfig;
	
	@Autowired
	UberLabTableColumnConfig uberLabTableColumnConfig;

	@Override
	public List<TableColumn> getDelveTableColumns() {
		return tableColumnMapper(delveTableColumnConfig.getTableColumns());
	}

	@Override
	public List<TableColumn> getRaceTo100TableColumns() {
		return tableColumnMapper(raceTableColumnConfig.getTableColumns());
	}

	@Override
	public List<TableColumn> getUberLabTableColumns() {
		return tableColumnMapper(uberLabTableColumnConfig.getTableColumns());
	}	
	
	private List<TableColumn> tableColumnMapper(List<String> columnsList) {
		List<TableColumn> tableColumnList = new ArrayList<>();
		for (String column :  columnsList) {
			tableColumnList.add(new TableColumn(column));
		}
		return tableColumnList;
	}

}	
