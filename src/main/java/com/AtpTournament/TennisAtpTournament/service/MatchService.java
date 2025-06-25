package com.AtpTournament.TennisAtpTournament.service;


import com.AtpTournament.TennisAtpTournament.entity.Match;
import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import com.AtpTournament.TennisAtpTournament.entityDto.MatchDto;
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
        Player playerOne = playerRepository.findById(matchRequest.getIdPlayerOne()).get();
        Tournament tournament = tournamentRepository.findById(matchRequest.getIdTournament()).get();
        Player playerTwo = playerRepository.findById(matchRequest.getIdPlayerTwo()).get();

        Match match = new Match();
        match.setTournament(tournament);
        match.setPlayer1(playerOne);
        match.setPlayer2(playerTwo);

        matchRepository.save(match);
        return match.getId();
    }

    public MatchDto GetMatch(Long id) {
        Match match = matchRepository.findById(id).get();

        return matchMapper.matchToMatchDto(match);
    }


    public void DeleteMatch(Long id) {
        Match match = matchRepository.findById(id).get();
        matchRepository.delete(match);
    }


}
