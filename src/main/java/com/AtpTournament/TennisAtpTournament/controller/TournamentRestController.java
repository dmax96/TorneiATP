package com.AtpTournament.TennisAtpTournament.controller;


import com.AtpTournament.TennisAtpTournament.entityDto.TournamentDto;
import com.AtpTournament.TennisAtpTournament.request.TournamentRequest;
import com.AtpTournament.TennisAtpTournament.service.TournamentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentRestController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/create")
    public long createTournamentService(@RequestBody @Valid TournamentRequest tournamentRequest) {
        return tournamentService.createTournament(tournamentRequest);
    }

    @GetMapping("/findBy/{id}")
    public TournamentDto getTournament(@RequestParam Long id) {
        return tournamentService.getTournament(id);
    }

    @DeleteMapping("/deleteBy/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.DeleteTournament(id);
    }

    @PostMapping("/updateBy/{id}")
    public TournamentDto updateTournament(@PathVariable Long id, @RequestBody @Valid TournamentRequest tournamentRequest) {
        return tournamentService.updateTournament(id, tournamentRequest);
    }

    @GetMapping("/search")
    public List<TournamentDto> searchByLocation(@RequestParam String location) {
        return tournamentService.searchByLocation(location);
    }

}
