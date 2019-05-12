package com.poe.ladder.backend.leaderboard.polling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class PollingScheduler {
	
	@Autowired
	LeaderboardPollingService leaderboardPollingService;
	
	private final static Logger LOG = LoggerFactory.getLogger(PollingScheduler.class);
	
	@Scheduled(initialDelay = 10000, fixedRate = 300000)
	public void pollLeaderboards() {
		LOG.info("pollLeaderboards() : leaderboard polling service initiated.");
		try {
			Runtime.getRuntime().gc();
			leaderboardPollingService.getLeaderboardRankings();
			LOG.info("pollLeaderboards() : leaderboard polling operation completed successfully.");
			java.lang.Thread.sleep(10000);
			Runtime.getRuntime().gc();
		} catch (InterruptedException ex) {
			throw new RuntimeException("pollLeaderboards encountered an InterruptedException :  " + ex);
		}
	}

}
		