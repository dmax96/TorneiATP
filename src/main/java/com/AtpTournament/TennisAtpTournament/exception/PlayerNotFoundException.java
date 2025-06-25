package com.AtpTournament.TennisAtpTournament.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("Tournament with id " +  id  + " not found");
    }
}
