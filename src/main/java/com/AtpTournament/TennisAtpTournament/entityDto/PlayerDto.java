package com.AtpTournament.TennisAtpTournament.entityDto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PlayerDto {
    private int id;
    private String name;
    private String surname;
    private String sponsor;
    private Date birthdate;
    private int rankingAtp;

    public PlayerDto(){

    }

    public PlayerDto(String name, String surname, String sponsor, Date dateOfBirth, int rankingAtp) {
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getRankingAtp() {
        return rankingAtp;
    }

    public void setRankingAtp(int rankingAtp) {
        this.rankingAtp = rankingAtp;
    }
}
