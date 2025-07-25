package com.AtpTournament.TennisAtpTournament.repository;

import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
        List<Tournament> findByLocationIgnoreCase(String location);
}
