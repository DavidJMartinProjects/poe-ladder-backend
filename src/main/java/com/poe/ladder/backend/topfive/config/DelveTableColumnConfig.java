package com.poe.ladder.backend.topfive.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datatables.topfive.delve")
public class DelveTableColumnConfig {
	
	@PostConstruct
	public void printList() {
		tableColumns.forEach(e -> System.out.println(e));
	}
	
	private List<String> tableColumns;

	public List<String> getTableColumns() {
		return tableColumns;
	}

	public void setTableColumns(List<String> tableColumns) {
		this.tableColumns = tableColumns;
	}

}
