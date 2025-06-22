package com.AtpTournament.TennisAtpTournament.repository;

import com.AtpTournament.TennisAtpTournament.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
