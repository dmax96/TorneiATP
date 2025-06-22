package com.AtpTournament.TennisAtpTournament.entity;


import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Player extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String sponsor;
    @DateTimeFormat
    @NotNull
    private LocalDateTime birthdate;
    @NotNull
    @Column(name = "ranking_atp")
    private int rankingAtp = 400;

    public Player(){

    }

    public Player(String name, String surname, String sponsor, LocalDateTime dateOfBirth, int rankingAtp) {
        this.name = name;
        this.surname = surname;
        this.sponsor = sponsor;
        this.birthdate = dateOfBirth;
        this.rankingAtp = rankingAtp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public int getRankingAtp() {
        return rankingAtp;
    }

    public void setRankingAtp(int rankingAtp) {
        this.rankingAtp = rankingAtp;
    }
}
