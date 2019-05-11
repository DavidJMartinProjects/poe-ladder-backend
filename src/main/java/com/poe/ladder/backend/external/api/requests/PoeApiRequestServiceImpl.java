package com.poe.ladder.backend.external.api.requests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poe.ladder.backend.external.api.requests.urls.LeaderboardUrlsService;
import com.poe.ladder.backend.external.api.response.ResponseEntry;
import com.poe.ladder.backend.leaderboard.domain.LeaderboardEntry;
import com.poe.ladder.backend.leagues.business.LeagueNameService;

@Service	
public class PoeApiRequestServiceImpl implements PoeApiRequestService {
	
	@Autowired
	LeagueNameService leagueNameService;	

	@Autowired
	LeaderboardUrlsService leaderboardUrlsService;
	
	@Autowired
	HttpRequestBuilder httpRequestBuilder;
	
	public static final String USER_AGENT_PARAM = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
	public static final String USER_AGENT = "user-agent";
	
	private List<LeaderboardEntry> delveRankings;	
	private List<Map<String, String>> leaderboardUrls;
	private String url = new String();
	private	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();

	public HttpEntity<String> entity;
	
	public PoeApiRequestServiceImpl() {
		leaderboardUrls = new ArrayList<Map<String,String>>();
		delveRankings = new ArrayList<>();
		setupHttpEntityHeaders();
	}
	
	@PostConstruct
	public void init() {
		leaderboardUrls = leaderboardUrlsService.getLeaderboardUrls();
		getLeaderboardRankings();
	}

	@Override
	public void getLeaderboardRankings() {
		for (Map<String, String> urlsList : leaderboardUrls) {
			for (Map.Entry<String, String> leagueUrl : urlsList.entrySet()) {
				url = leagueUrl.getValue();
				System.out.println("===================");
				System.out.println(url);
				System.out.println("===================");
				requestDelveLeaderboards(url);
				break;
			}
		}
	}

	private Object requestDelveLeaderboards(String url) {
		ResponseEntity<ResponseEntry> apiRequest = restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntry.class);
		ResponseEntry responseBody = apiRequest.getBody();
		System.out.println("responseBody : " + responseBody.toString());
		return responseBody;	
	}
	
	private void setupHttpEntityHeaders() {
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add(USER_AGENT, USER_AGENT_PARAM);
		headers.add("Accept-Encoding",  "gzip deflate");
		headers.add("Accept-Language",  "en-US en");
		headers.add("Upgrade-Insecure-Requests",  "1");
		headers.add("Cookie",  "__cfduid=d26f0e1ca08b926e10a926dcda9302cfa1546206260");
		headers.add("Cookie",  "POESESSID=3a4fa1c3e399804bf49bef466270e484");
		headers.add("Cookie",  "cf_clearance=b32a2a1c3b51d4bfde7de0cbf7fbc5015de28b0d-1546218127-300-150");
		headers.add("Cookie",  "_ga=GA1.2.1564561921.1546218143");
		headers.add("Cookie",  "_gid=GA1.2.350283217.1546218143");
		entity = new HttpEntity<String>("parameters", headers);
	}

}
	