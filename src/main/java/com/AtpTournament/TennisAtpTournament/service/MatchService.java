package com.AtpTournament.TennisAtpTournament.service;


import com.AtpTournament.TennisAtpTournament.entity.Match;
import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import com.AtpTournament.TennisAtpTournament.entityDto.MatchDto;
import com.AtpTournament.TennisAtpTournament.exception.InvalidPlayerException;
import com.AtpTournament.TennisAtpTournament.exception.InvalidTournamentException;
import com.AtpTournament.TennisAtpTournament.exception.MatchNotFoundException;
import com.AtpTournament.TennisAtpTournament.mapper.MatchMapper;
import com.AtpTournament.TennisAtpTournament.repository.MatchRepository;
import com.AtpTournament.TennisAtpTournament.repository.PlayerRepository;
import com.AtpTournament.TennisAtpTournament.repository.TournamentRepository;
import com.AtpTournament.TennisAtpTournament.request.MatchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private MatchMapper matchMapper;


    public Long CreateMatch(MatchRequest matchRequest) {
        log.info("Creating a match...");
        log.info("searching player one...");
        Player playerOne = playerRepository.findById(matchRequest.getIdPlayerOne()).
                orElseThrow(() -> new InvalidPlayerException("Player 1 not found with id " + matchRequest.getIdPlayerOne()));
        log.info("searching tournament...");
        Tournament tournament = tournamentRepository.findById(matchRequest.getIdTournament()).
                orElseThrow(() -> new InvalidTournamentException(("Tournament not found with id " + matchRequest.getIdTournament())));
        Player playerTwo = playerRepository.findById(matchRequest.getIdPlayerTwo()).
                orElseThrow(() -> new InvalidPlayerException("Player 2 not found with id " + matchRequest.getIdPlayerTwo()));
        if(playerOne == playerTwo) {
            throw new InvalidPlayerException("Player 1 is the same as the player 2");
        }

        log.info("All credetial valid!");
        Match match = new Match();
        match.setTournament(tournament);
        match.setPlayer1(playerOne);
        match.setPlayer2(playerTwo);

        matchRepository.save(match);
        log.info("Match created!");
        return match.getId();
    }

    public MatchDto GetMatch(Long id) {
        log.info("Getting a match...");
        Match match = matchRepository.findById(id).
                orElseThrow(() -> new MatchNotFoundException(id));
        log.info("match found!");
        return matchMapper.matchToMatchDto(match);
    }


    public void DeleteMatch(Long id) {
        log.info("Deleting match...");
        Match match = matchRepository.findById(id).
                orElseThrow(() -> new MatchNotFoundException(id));
        log.info("match deleted!");
        matchRepository.delete(match);
    }


}
