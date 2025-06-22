package com.AtpTournament.TennisAtpTournament.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    @Column(name = "insert_date")
    @CreationTimestamp
    private LocalDateTime insertDate;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime updateDate;
    @NotNull
    private String operator = "system";

    public BaseEntity() {

    }

    public BaseEntity(LocalDateTime insertDate, LocalDateTime updateDate, String operator) {
        this.insertDate = insertDate;
        this.updateDate = updateDate;
        this.operator = operator;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
