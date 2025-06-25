package com.AtpTournament.TennisAtpTournament.entityDto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class PlayerDto {
    private int id;
    private String name;
    private String surname;
    private String sponsor;
    private Date birthdate;
    private int rankingAtp;

}
