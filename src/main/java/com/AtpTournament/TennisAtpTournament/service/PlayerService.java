package com.AtpTournament.TennisAtpTournament.service;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.entityDto.PlayerDto;
import com.AtpTournament.TennisAtpTournament.mapper.PlayerMapper;
import com.AtpTournament.TennisAtpTournament.repository.PlayerRepository;
import com.AtpTournament.TennisAtpTournament.request.PlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerMapper playerMapper;

    public int CreatePlayer(PlayerRequest playerRequest) {
        Player player = playerMapper.PlayerRequestToPlayer(playerRequest);
        playerRepository.save(player);
        return player.getId();
    }

    public List<PlayerDto> GetPlayerByName(String name) {
        List<PlayerDto> playersDto = new ArrayList<>();
        List<Player> players = playerRepository.findAllByNameIgnoreCase(name);
        for (Player player : players) {
            playersDto.add(playerMapper.PlayerToPlayerDto(player));
        }

       return playersDto;
    }

    public PlayerDto GetPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        return playerMapper.PlayerToPlayerDto(player.get());
    }

    public void DeletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public List<PlayerDto> GetAllPlayers() {
        List<Player> players = playerRepository.findAll();
        List<PlayerDto> playersDto = new ArrayList<>();
        for (Player player : players) {
            playersDto.add(playerMapper.PlayerToPlayerDto(player));
        }
        return playersDto;
    }

    public List<PlayerDto> GetAllPlayersBySponsor(String sponsor) {
        List<PlayerDto> playersDto = new ArrayList<>();
        List<Player> players = playerRepository.findAllBySponsorIgnoreCase(sponsor);
        for (Player player : players) {
            playersDto.add(playerMapper.PlayerToPlayerDto(player));
        }
        return playersDto;
    }

    public PlayerDto UpdatePlayer(Long id, PlayerRequest playerRequest) {
        Player player = playerRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Player not found by id" + id));
        playerMapper.updatePlayer(playerRequest, player);
        playerRepository.save(player);
        return playerMapper.PlayerToPlayerDto(player);
    }


}
