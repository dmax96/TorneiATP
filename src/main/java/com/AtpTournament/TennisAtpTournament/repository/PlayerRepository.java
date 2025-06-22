package com.AtpTournament.TennisAtpTournament.repository;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByNameIgnoreCase(String name);
    List<Player> findAllBySponsorIgnoreCase(String sponsor);
}
