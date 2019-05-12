package com.poe.ladder.backend.external.api.requests;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poe.ladder.backend.external.api.response.domain.Entry;
import com.poe.ladder.backend.external.api.response.domain.ResponseEntry;

@Service
public class LeaderboardApiRequestServiceImpl implements LeaderboardApiRequestService {
	
	@Autowired
	HttpEntityBuilder httpEntityBuilder;
	
	private HttpEntity<String> entity;
	private RestTemplate restTemplate;
	
	@PostConstruct
	public void init() throws InterruptedException {
		entity = httpEntityBuilder.getConfiguredHttpEntity();
		restTemplate = new RestTemplate();
	}

	@Override
	public List<Entry> requestLeaderboardFromPoeApi(String url)  {
		sleepBeforeNextApiRequest();
		ResponseEntity<ResponseEntry> leaderboardApiRequest = restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntry.class);
		ResponseEntry leaderboardApiResponse = leaderboardApiRequest.getBody();
		return leaderboardApiResponse.getEntries();
	}
	
	private void sleepBeforeNextApiRequest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			throw new RuntimeException("sleepBeforeNextApiRequest() encountered an InterruptedException : " + ex);
		}
	}

}
	