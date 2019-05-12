package com.poe.ladder.backend.leaderboard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poe.ladder.backend.leaderboard.domain.BaseEntry;

@Repository
public interface LeaderboardRepository extends JpaRepository<BaseEntry, Long> {
}
						