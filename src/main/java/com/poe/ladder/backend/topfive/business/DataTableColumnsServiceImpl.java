package com.poe.ladder.backend.topfive.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.topfive.config.DelveTableColumnConfig;
import com.poe.ladder.backend.topfive.config.RaceTableColumnConfig;
import com.poe.ladder.backend.topfive.config.UberLabTableColumnConfig;

@Service
public class DataTableColumnsServiceImpl implements DataTableColumnsService {
	
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
