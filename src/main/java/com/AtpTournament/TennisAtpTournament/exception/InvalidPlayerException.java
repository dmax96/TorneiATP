package com.AtpTournament.TennisAtpTournament.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidPlayerException extends RuntimeException {
    public InvalidPlayerException(String message) {
        super("Invalid player data " + message );
    }
}
