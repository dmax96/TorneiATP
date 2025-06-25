package com.AtpTournament.TennisAtpTournament.entityDto;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MatchDto {
    private int id;
    private Tournament tournament;
    private Player player1;
    private Player player2;
    private LocalDateTime matchDate;


}
