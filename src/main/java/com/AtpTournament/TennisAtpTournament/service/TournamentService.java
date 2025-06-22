package com.AtpTournament.TennisAtpTournament.service;
import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import com.AtpTournament.TennisAtpTournament.entityDto.TournamentDto;
import com.AtpTournament.TennisAtpTournament.mapper.TournamentMapper;
import com.AtpTournament.TennisAtpTournament.repository.TournamentRepository;
import com.AtpTournament.TennisAtpTournament.request.TournamentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentMapper tournamentMapper;

    public Long createTournament(TournamentRequest tournamentRequest) {
        Tournament tournament = tournamentMapper.tournamentRequestToTournament(tournamentRequest);
        tournamentRepository.save(tournament);
        return tournament.getId();
    }

    public TournamentDto getTournament(Long id) {
        Tournament tournament = tournamentRepository.findById(id).get();
        return tournamentMapper.tournamentToTournamentDto(tournament);
    }

    public void DeleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    public TournamentDto updateTournament(Long id, TournamentRequest tournamentRequest) {
        Tournament tournament = tournamentRepository.findById(id).get();
        tournamentMapper.updateTournament(tournamentRequest, tournament);
        tournamentRepository.save(tournament);
        return tournamentMapper.tournamentToTournamentDto(tournament);
    }

}
