package com.AtpTournament.TennisAtpTournament.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PlayerRequest {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String sponsor;
    @NotNull
    private LocalDateTime birthdate;

}
