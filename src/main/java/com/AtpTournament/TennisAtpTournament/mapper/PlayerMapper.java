package com.AtpTournament.TennisAtpTournament.mapper;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.entityDto.PlayerDto;
import com.AtpTournament.TennisAtpTournament.request.PlayerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    Player PlayerRequestToPlayer(PlayerRequest playerRequest);
    PlayerDto PlayerToPlayerDto(Player player);
    void updatePlayer(PlayerRequest playerRequest, @MappingTarget Player player);
}
