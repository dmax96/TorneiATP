package com.AtpTournament.TennisAtpTournament.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
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


}
