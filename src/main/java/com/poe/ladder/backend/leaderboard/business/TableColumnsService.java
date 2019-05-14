package com.poe.ladder.backend.leaderboard.business;

import java.util.List;

import com.poe.ladder.backend.leaderboard.web.TableColumn;

public interface TableColumnsService {	
	public List<TableColumn> getDelveTableColumns();	
	public List<TableColumn> getRaceTo100TableColumns();	
	public List<TableColumn> getUberLabTableColumns();	
}
