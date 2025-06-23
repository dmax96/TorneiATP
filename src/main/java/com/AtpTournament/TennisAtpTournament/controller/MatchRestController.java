package com.AtpTournament.TennisAtpTournament.controller;


import com.AtpTournament.TennisAtpTournament.entityDto.MatchDto;
import com.AtpTournament.TennisAtpTournament.repository.MatchRepository;
import com.AtpTournament.TennisAtpTournament.request.MatchRequest;
import com.AtpTournament.TennisAtpTournament.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchRestController {

    @Autowired
    MatchService matchService;

    @PostMapping("/create")
    public Long getMatchId(@RequestBody MatchRequest matchRequest) {

        return matchService.CreateMatch(matchRequest);
    }

    @GetMapping("/getById/{id}")
    public MatchDto getMatch(@PathVariable Long id) {
        return matchService.GetMatch(id);
    }

    @DeleteMapping("/DeleteById/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.DeleteMatch(id);
    }

}
