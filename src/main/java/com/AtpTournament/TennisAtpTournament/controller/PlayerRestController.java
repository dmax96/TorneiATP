package com.AtpTournament.TennisAtpTournament.controller;

import com.AtpTournament.TennisAtpTournament.entityDto.PlayerDto;
import com.AtpTournament.TennisAtpTournament.request.PlayerRequest;
import com.AtpTournament.TennisAtpTournament.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerRestController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/create")
    public int createPlayer(@RequestBody PlayerRequest playerRequest) {
        return playerService.CreatePlayer(playerRequest);
    }

    @GetMapping("/findByName/{name}")
    public List<PlayerDto> findByName(@PathVariable String name) {
        return playerService.GetPlayerByName(name);
    }

    @GetMapping("/findById/{id}")
    public PlayerDto findById(@PathVariable Long id) {
        return playerService.GetPlayerById(id);
    }

    @DeleteMapping("/DeleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        playerService.DeletePlayer(id);
    }

    @GetMapping("/findAll")
    public List<PlayerDto> findAll() {
        return playerService.GetAllPlayers();
    }

    @GetMapping("/findBySponsor/{sponsor}")
    public List<PlayerDto> findBySponsor(@PathVariable String sponsor) {
        return playerService.GetAllPlayersBySponsor(sponsor);
    }

    @PostMapping("/updatePlayerById/{id}")
    public PlayerDto addPlayer(@PathVariable Long id, @RequestBody PlayerRequest playerRequest) {
        return playerService.UpdatePlayer(id, playerRequest);
    }

    @GetMapping("/SortByAtp")
    public List<PlayerDto> SortByAtp() {
        return playerService.getPlayerRanking();
    }

}
