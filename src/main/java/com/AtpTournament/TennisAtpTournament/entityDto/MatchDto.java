package com.AtpTournament.TennisAtpTournament.entityDto;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.entity.Tournament;
import jakarta.persistence.*;

import java.util.Date;

public class MatchDto {
    private int id;
    private Tournament tournament;
    private Player player1;
    private Player player2;

    private Date match_date = null;


    public MatchDto(){

    }

    public MatchDto(int id, Tournament tournament, Player player1, Player player2, Date match_date) {
        this.id = id;
        this.tournament = tournament;
        this.player1 = player1;
        this.player2 = player2;
        this.match_date = match_date;
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

    public Date getMatch_date() {
        return match_date;
    }

    public void setMatch_date(Date match_date) {
        this.match_date = match_date;
    }
}
