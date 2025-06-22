package com.AtpTournament.TennisAtpTournament.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Match extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_tournament")
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "id_player")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "id_player2")
    private Player player2;

    private Date match_date = null;


    public Match(){

    }

    public Match(Tournament tournament, Player player1, Player player2, Date match_date) {
        this.tournament = tournament;
        this.player1 = player1;
        this.player2 = player2;
        this.match_date = match_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
