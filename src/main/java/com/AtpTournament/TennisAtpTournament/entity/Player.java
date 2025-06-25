package com.AtpTournament.TennisAtpTournament.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
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

    @OneToMany(mappedBy = "player1", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Match> matchesAsFirst = new ArrayList<>();

    @OneToMany(mappedBy = "player2", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Match> matchesAsSecond = new ArrayList<>();
}