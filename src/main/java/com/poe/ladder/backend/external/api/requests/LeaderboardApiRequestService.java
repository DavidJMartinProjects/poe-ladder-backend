package com.poe.ladder.backend.external.api.requests;

import java.util.List;

import com.poe.ladder.backend.external.api.response.domain.Entry;

public interface LeaderboardApiRequestService {
	List<Entry> requestLeaderboardFromPoeApi(String url);
}
	