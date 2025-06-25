package com.AtpTournament.TennisAtpTournament.entityDto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class TournamentDto {
    private int id;
    private String name;
    private String location;

}
