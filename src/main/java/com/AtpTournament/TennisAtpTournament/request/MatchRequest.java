package com.AtpTournament.TennisAtpTournament.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MatchRequest {
    @NotBlank
    private Long idTournament;
    @NotBlank
    private Long idPlayerOne;
    @NotBlank
    private Long idPlayerTwo;

}
