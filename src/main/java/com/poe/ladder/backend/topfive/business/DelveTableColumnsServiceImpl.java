package com.poe.ladder.backend.topfive.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poe.ladder.backend.topfive.config.DelveTableColumnConfig;

@Service
public class DelveTableColumnsServiceImpl implements DelveTableColumnsService {
	
	@Autowired
	DelveTableColumnConfig delveTableColumnConfig;

	@Override
	public List<String> getTableColumns() {
		return delveTableColumnConfig.getTableColumns();
	}	

}	
