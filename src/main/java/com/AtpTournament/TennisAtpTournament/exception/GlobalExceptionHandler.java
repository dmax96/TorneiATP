package com.AtpTournament.TennisAtpTournament.exception;

import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
    @ExceptionHandler(PlayerNotFoundException.class)
    public void HandlePlayerNotFoundException(PlayerNotFoundException e) {
        log.error(e.getMessage());
    }

    @ExceptionHandler(MatchNotFoundException.class)
    public void HandleMatchNotFoundException(MatchNotFoundException e) {
        log.error(e.getMessage());
    }

    @ExceptionHandler(TournamentNotFoundException.class)
    public void HandleTournamentNotFoundException(TournamentNotFoundException e) {
        log.error(e.getMessage());
    }



}
