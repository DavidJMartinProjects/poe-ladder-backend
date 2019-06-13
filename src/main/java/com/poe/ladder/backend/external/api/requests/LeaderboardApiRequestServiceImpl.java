package com.poe.ladder.backend.external.api.requests;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final static Logger LOG = LoggerFactory.getLogger(LeaderboardApiRequestServiceImpl.class);
	
	@PostConstruct
	public void init() throws InterruptedException {
		entity = httpEntityBuilder.getConfiguredHttpEntity();
		restTemplate = new RestTemplate();
	}	

	@Override
	public List<Entry> requestLeaderboardFromPoeApi(String url)  {
		List<Entry> responseList = new ArrayList<Entry>();
		try {
			sleepBeforeNextApiRequest();
			LOG.info("requestLeaderboardFromPoeApi() : performing httprequest to {}", url);
			ResponseEntity<ResponseEntry> leaderboardApiRequest = restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntry.class);
			ResponseEntry leaderboardApiResponse = leaderboardApiRequest.getBody();
			responseList = leaderboardApiResponse.getEntries();
		} catch (Exception ex) {
			LOG.info("poe api response error.");
		}
		return responseList;
	}
	
	private void sleepBeforeNextApiRequest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			throw new RuntimeException("sleepBeforeNextApiRequest() encountered an InterruptedException : " + ex);
		}
	}	

}
	