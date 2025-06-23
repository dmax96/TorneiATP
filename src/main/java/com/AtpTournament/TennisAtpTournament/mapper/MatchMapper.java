package com.AtpTournament.TennisAtpTournament.mapper;

import com.AtpTournament.TennisAtpTournament.entity.Match;
import com.AtpTournament.TennisAtpTournament.entityDto.MatchDto;
import com.AtpTournament.TennisAtpTournament.request.MatchRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    Match matchRequestToMatch(MatchRequest matchRequest);
    MatchDto matchToMatchDto(Match match);
}
