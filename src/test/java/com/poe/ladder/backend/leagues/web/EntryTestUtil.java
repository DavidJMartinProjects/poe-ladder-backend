package com.poe.ladder.backend.leagues.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.poe.ladder.backend.external.api.response.domain.Account;
import com.poe.ladder.backend.external.api.response.domain.Entry;

public class EntryTestUtil {
	

	List<Entry> entriesList =  new ArrayList<>();
	Entry entryOne;
	Entry entryTwo;
	Entry entryThree;
	
	@PostConstruct
	public void init() {
		entryOne = new Entry();
		entryOne.setAccount(new Account());	
		
		entryTwo = new Entry();
		entryTwo.setAccount(new Account());
		
		entryThree = new Entry();
		entryThree.setAccount(new Account());
	}
	
	public List<Entry> getEntries() {
		entriesList.add(entryOne);
		entriesList.add(entryTwo);
		entriesList.add(entryThree);	
		return entriesList;
	}	
	
}
