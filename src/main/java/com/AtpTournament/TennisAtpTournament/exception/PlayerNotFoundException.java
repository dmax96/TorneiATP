package com.AtpTournament.TennisAtpTournament.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("Giocatore con ID " + id + " non trovato");
    }
}
