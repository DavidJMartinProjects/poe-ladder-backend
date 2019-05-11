package com.poe.ladder.backend.topfive.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poe.ladder.backend.topfive.business.DelveTableColumnsService;

@RestController
public class TableColumnControllerImpl implements TableColumnController {
	
	@Autowired
	DelveTableColumnsService delveTableColumnsService;

	@GetMapping("delve-columns")
	public List<String> getDelveTableColumns() {
		System.out.println("getDelveTableColumns");
		return delveTableColumnsService.getTableColumns();
	}

}	
