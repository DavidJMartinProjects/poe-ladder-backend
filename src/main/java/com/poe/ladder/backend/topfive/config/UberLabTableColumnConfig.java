package com.poe.ladder.backend.topfive.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datatables.topfive.uberlab")
public class UberLabTableColumnConfig {
	
	List<String> tableColumns;	

	public List<String> getTableColumns() {
		return tableColumns;
	}

	public void setTableColumns(List<String> tableColumns) {
		this.tableColumns = tableColumns;
	}

}
