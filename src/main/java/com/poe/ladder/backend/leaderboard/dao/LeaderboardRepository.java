package com.poe.ladder.backend.leaderboard.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

@Repository
public interface LeaderboardRepository extends JpaRepository<LeaderBoardEntry, Long> {
//	List<LeaderBoardEntry> findTop5ByDepthByLeagueLikeIgnoreCaseAndLeaderboard(String league, String leaderboard);
	@Query(value="SELECT * FROM leader_board_entry WHERE league LIKE ?1 AND leaderboard = ?2 LIMIT 5", nativeQuery = true)
	List<LeaderBoardEntry> getLeaderboardEntryResults(String league, String leaderboard);
}	
									