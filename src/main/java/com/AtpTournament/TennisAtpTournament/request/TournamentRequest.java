package com.AtpTournament.TennisAtpTournament.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TournamentRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String location;

}
