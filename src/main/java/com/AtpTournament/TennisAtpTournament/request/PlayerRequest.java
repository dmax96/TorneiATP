package com.AtpTournament.TennisAtpTournament.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PlayerRequest {
    private String name;
    private String surname;
    private String sponsor;
    private LocalDateTime birthdate;

}
