package com.poe.ladder.backend.leaderboard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poe.ladder.backend.leaderboard.domain.LeaderBoardEntry;

@Repository
public interface LeaderboardRepository extends JpaRepository<LeaderBoardEntry, Long> {
}
						