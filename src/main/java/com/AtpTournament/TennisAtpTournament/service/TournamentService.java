package com.AtpTournament.TennisAtpTournament.service;
import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import com.AtpTournament.TennisAtpTournament.entityDto.TournamentDto;
import com.AtpTournament.TennisAtpTournament.exception.InvalidTournamentException;
import com.AtpTournament.TennisAtpTournament.exception.TournamentNotFoundException;
import com.AtpTournament.TennisAtpTournament.mapper.TournamentMapper;
import com.AtpTournament.TennisAtpTournament.repository.TournamentRepository;
import com.AtpTournament.TennisAtpTournament.request.TournamentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentMapper tournamentMapper;

    public Long createTournament(TournamentRequest tournamentRequest) {
        log.info("Creating tournament " + tournamentRequest.getName());
        if(tournamentRequest.getName() == null || tournamentRequest.getName().trim().isEmpty()) {
            throw new InvalidTournamentException("Request empty");
        }
        Tournament tournament = tournamentMapper.tournamentRequestToTournament(tournamentRequest);
        tournamentRepository.save(tournament);
        log.info("Created  " + tournamentRequest.getName() + "  tournament!");
        return tournament.getId();
    }

    public TournamentDto getTournament(Long id) {
        log.info("Retrieving tournament " + id);
        Tournament tournament = tournamentRepository.findById(id).
                orElseThrow(() -> new TournamentNotFoundException(id));
        log.info("Tournament " + tournament.getName() + " founded!");
        return tournamentMapper.tournamentToTournamentDto(tournament);
    }

    public void DeleteTournament(Long id) {
        log.info("Deleting tournament " + id);
        if(tournamentRepository.existsById(id)) {
            tournamentRepository.deleteById(id);
            log.info("Deleted  " + id + " tournament!");
        }
        else {
            throw new TournamentNotFoundException(id);
        }
    }

    public TournamentDto updateTournament(Long id, TournamentRequest tournamentRequest) {
        log.info("Updating tournament " + id);
        Tournament tournament = tournamentRepository.findById(id).
                orElseThrow(() -> new TournamentNotFoundException(id));
        if(tournamentRequest.getName() == null || tournamentRequest.getName().trim().isEmpty()) {
            throw new InvalidTournamentException("name is not provided. it still remain the same");
        }
        tournamentMapper.updateTournament(tournamentRequest, tournament);
        tournamentRepository.save(tournament);
        log.info( "tournament updated!");
        return tournamentMapper.tournamentToTournamentDto(tournament);
    }

    public List<TournamentDto> searchByLocation(String location) {
        log.info("Searching tournament from  " + location);
        List<Tournament> tournaments = tournamentRepository.findByLocationIgnoreCase(location);
        log.info("Found " + tournaments.size() + " tournaments");
        return tournaments.stream()
                .map(tournamentMapper::tournamentToTournamentDto)
                .toList();
    }

}
