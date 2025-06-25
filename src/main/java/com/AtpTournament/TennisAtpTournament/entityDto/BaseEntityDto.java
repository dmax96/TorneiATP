package com.AtpTournament.TennisAtpTournament.entityDto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseEntityDto {

    private LocalDateTime insertDate;
    private LocalDateTime updateDate;
    private String operator = "system";

}
