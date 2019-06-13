package com.poe.ladder.backend.leaderboard.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.external.api.response.mapper.LeaderboardMappingServiceImpl;
import com.poe.ladder.backend.leaderboard.web.TableColumn;
import com.poe.ladder.backend.leagues.config.DelveTableColumnConfig;
import com.poe.ladder.backend.leagues.config.RaceTableColumnConfig;
import com.poe.ladder.backend.leagues.config.UberLabTableColumnConfig;

@Service
public class TableColumnsServiceImpl implements TableColumnsService {
	
	@Autowired
	DelveTableColumnConfig delveTableColumnConfig;
	
	@Autowired
	RaceTableColumnConfig raceTableColumnConfig;
	
	@Autowired
	UberLabTableColumnConfig uberLabTableColumnConfig;
	
	private static final Logger LOG = LoggerFactory.getLogger(LeaderboardMappingServiceImpl.class);

	@Override
	public List<TableColumn> getDelveTableColumns() {
		LOG.info("TableColumnsServiceImpl: retrieving table columns for delve leaderboard.");
		return tableColumnMapper(delveTableColumnConfig.getTableColumns());
	}

	@Override
	public List<TableColumn> getRaceTo100TableColumns() {
		LOG.info("TableColumnsServiceImpl: retrieving table columns for raceTo100 leaderboard.");
		return tableColumnMapper(raceTableColumnConfig.getTableColumns());
	}

	@Override
	public List<TableColumn> getUberLabTableColumns() {
		LOG.info("TableColumnsServiceImpl: retrieving table columns for uberlab leaderboard.");
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
