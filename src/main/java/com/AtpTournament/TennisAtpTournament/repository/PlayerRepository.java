package com.AtpTournament.TennisAtpTournament.repository;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByNameIgnoreCase(String name);
    List<Player> findAllBySponsorIgnoreCase(String sponsor);
    List<Player> findAllByOrderByRankingAtpDesc();
}
