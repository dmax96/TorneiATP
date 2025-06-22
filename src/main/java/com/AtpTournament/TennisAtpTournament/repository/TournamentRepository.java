package com.AtpTournament.TennisAtpTournament.repository;

import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}
