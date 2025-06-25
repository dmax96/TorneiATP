package com.AtpTournament.TennisAtpTournament.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MatchRequest {
    private Long idTournament;
    private Long idPlayerOne;
    private Long idPlayerTwo;

}
