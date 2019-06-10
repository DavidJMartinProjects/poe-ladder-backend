package com.poe.ladder.backend.leaderboard.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;	
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class UpdateLeaderboardScheduler {
	
	@Autowired
	UpdateLeaderboardService leaderboardPollingService;
	
	@Autowired
	CacheManager cacheManager;	
	
	private final static Logger LOG = LoggerFactory.getLogger(UpdateLeaderboardScheduler.class);
	
	@Scheduled(initialDelay = 10000, fixedRate = 600000)
	public void pollLeaderboards() throws InterruptedException {
		LOG.info("pollLeaderboards() : leaderboard polling service initiated.");
		try {
			Runtime.getRuntime().gc();
			leaderboardPollingService.getLeaderboardRankings();
			LOG.info("pollLeaderboards() : all requests to external api's completed successfully.");
		} catch (InterruptedException ex) {
			throw new RuntimeException("pollLeaderboards encountered an InterruptedException :  " + ex);
		} finally {
			LOG.info("clearing cache and sleeping for garbage collection.");
			clearCache("leaderboards");
			java.lang.Thread.sleep(10000);
			Runtime.getRuntime().gc();	
			LOG.info("garbage collection complete. leaderboard polling operation completed successfully.");
		}
	}

	public void clearCache(String cacheName) {
	    cacheManager.getCache(cacheName).clear();
	}

}
			