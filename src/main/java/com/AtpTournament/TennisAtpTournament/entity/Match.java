package com.AtpTournament.TennisAtpTournament.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Match extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_tournament")
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "id_first_player")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "id_second_player")
    private Player player2;

    @CreationTimestamp
    @Column(name = "match_date")
    private LocalDateTime matchDate;


    public Match(){

    }

    public Match(Tournament tournament, Player player1, Player player2, LocalDateTime matchDate) {
        this.tournament = tournament;
        this.player1 = player1;
        this.player2 = player2;
        this.matchDate = matchDate;
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

    public LocalDateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDateTime matchDate) {
        this.matchDate = matchDate;
    }
}
