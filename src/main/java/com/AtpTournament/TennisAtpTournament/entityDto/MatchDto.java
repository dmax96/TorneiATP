package com.AtpTournament.TennisAtpTournament.entityDto;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import jakarta.persistence.*;

import java.time.LocalDateTime;


public class MatchDto {
    private int id;
    private Tournament tournament;
    private Player player1;
    private Player player2;
    private LocalDateTime matchDate;


    public MatchDto(){

    }

    public MatchDto(int id, Tournament tournament, Player player1, Player player2, LocalDateTime matchDate) {
        this.id = id;
        this.tournament = tournament;
        this.player1 = player1;
        this.player2 = player2;
        this.matchDate = matchDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }
}
