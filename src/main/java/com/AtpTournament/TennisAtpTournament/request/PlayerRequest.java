package com.AtpTournament.TennisAtpTournament.request;

import java.time.LocalDateTime;

public class PlayerRequest {
    private String name;
    private String surname;
    private String sponsor;
    private LocalDateTime birthdate;

    public PlayerRequest(String name, String surname, String sponsor, LocalDateTime birthdate) {
        this.name = name;
        this.surname = surname;
        this.sponsor = sponsor;
        this.birthdate = birthdate;
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
}
