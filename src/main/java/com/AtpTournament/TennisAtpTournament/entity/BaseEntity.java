package com.AtpTournament.TennisAtpTournament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Column(name = "insert_date")
    @CreationTimestamp
    private LocalDateTime insertDate;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime updateDate;
    @NotNull
    private String operator = "system";

}
