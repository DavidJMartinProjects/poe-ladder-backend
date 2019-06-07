package com.poe.ladder.backend.leaderboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

@Repository
public interface LeaderboardRepository extends JpaRepository<LeaderBoardEntry, Long> {
	@Query(value="SELECT * FROM leader_board_entry WHERE league=?1 AND leaderboard=?2 LIMIT ?3", nativeQuery = true)
	List<LeaderBoardEntry> getLeaderboardEntryResults(String leagueVariation, String leaderboard, int limit);

	@Query(value="SELECT * FROM leader_board_entry WHERE league=?1 AND leaderboard=?2 LIMIT 100", nativeQuery = true)
	List<LeaderBoardEntry> getLeaderboardLadderResults(String leagueName, String leaderboard);
	
}	
										