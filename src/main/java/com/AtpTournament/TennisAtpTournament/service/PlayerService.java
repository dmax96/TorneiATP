package com.AtpTournament.TennisAtpTournament.service;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.entityDto.PlayerDto;
import com.AtpTournament.TennisAtpTournament.exception.InvalidPlayerException;
import com.AtpTournament.TennisAtpTournament.exception.PlayerNotFoundException;
import com.AtpTournament.TennisAtpTournament.mapper.PlayerMapper;
import com.AtpTournament.TennisAtpTournament.repository.PlayerRepository;
import com.AtpTournament.TennisAtpTournament.request.PlayerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerMapper playerMapper;

    public int CreatePlayer(PlayerRequest playerRequest) {
        log.info("Creating new player");
        Player player = playerMapper.PlayerRequestToPlayer(playerRequest);
        if(player.getName() == null || player.getName().trim().isEmpty()) {
            throw new InvalidPlayerException("Player name cannot be empty");
        }
        playerRepository.save(player);
        log.info("Player with name  " + playerRequest.getName() + "  created!");
        return player.getId();
    }

    public List<PlayerDto> GetPlayerByName(String name) {
        log.info("Getting players by name...");
        List<PlayerDto> playersDto = new ArrayList<>();
        List<Player> players = playerRepository.findAllByNameIgnoreCase(name);
        if(players.isEmpty()) {
            throw new InvalidPlayerException("player with name  " + name + " not found");
        }
        for (Player player : players) {
            playersDto.add(playerMapper.PlayerToPlayerDto(player));
        }
        log.info("Player/s with name " + name +  " found!");
       return playersDto;
    }

    public PlayerDto GetPlayerById(Long id) {
        log.info("Searching player by id : {}", id);
        Player player = playerRepository.findById(id).
                orElseThrow(() -> new PlayerNotFoundException(id));
        log.info("Player found! dto sended");
        return playerMapper.PlayerToPlayerDto(player);
    }

    public void DeletePlayer(Long id) {
        log.info("Deleting player by id : {}", id);
        if(playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            log.info("Player deleted!");
        }
        else{
            throw new PlayerNotFoundException(id);
        }
    }

    public List<PlayerDto> GetAllPlayers() {
        log.info("Searching all players");
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty()) {
            throw new InvalidPlayerException("No players found");
        }
        List<PlayerDto> playersDto = new ArrayList<>();
        for (Player player : players) {
            playersDto.add(playerMapper.PlayerToPlayerDto(player));
        }
        log.info("All player provided!");
        return playersDto;
    }

    public List<PlayerDto> GetAllPlayersBySponsor(String sponsor) {
        log.info("Searching all players by sponsor : {}", sponsor);
        List<PlayerDto> playersDto = new ArrayList<>();
        List<Player> players = playerRepository.findAllBySponsorIgnoreCase(sponsor);
        if(players.isEmpty()) {
            throw new InvalidPlayerException("Sponsor not found");
        }
        for (Player player : players) {
            playersDto.add(playerMapper.PlayerToPlayerDto(player));
        }
        log.info("Plyers sorted by sponsor " + sponsor + " provided!");
        return playersDto;
    }

    public PlayerDto UpdatePlayer(Long id, PlayerRequest playerRequest) {
        log.info("Updating player with id : {}", id);
        Player player = playerRepository.findById(id).
                orElseThrow(() -> new PlayerNotFoundException(id));
        playerMapper.updatePlayer(playerRequest, player);
        playerRepository.save(player);
        log.info("Player updated!");
        return playerMapper.PlayerToPlayerDto(player);
    }

    public List<PlayerDto> getPlayerRanking() {
        log.info("filter players by ranking");
        List<Player> players = playerRepository.findAllByOrderByRankingAtpDesc();
        if(players.isEmpty()) {
            throw new InvalidPlayerException("No players found");
        }
        log.info("players filtered!");
        return players.stream()
                .map(playerMapper::PlayerToPlayerDto)
                .toList();
    }




}
