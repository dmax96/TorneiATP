package com.AtpTournament.TennisAtpTournament.mapper;


import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import com.AtpTournament.TennisAtpTournament.entityDto.TournamentDto;
import com.AtpTournament.TennisAtpTournament.request.TournamentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TournamentMapper {
    Tournament tournamentRequestToTournament(TournamentRequest tournamentRequest);
    TournamentDto tournamentToTournamentDto(Tournament tournament);
    Tournament updateTournament(TournamentRequest tournamentRequest, @MappingTarget Tournament tournament);
}
