package com.AtpTournament.TennisAtpTournament.exception;

public class InvalidTournamentException extends RuntimeException {
    public InvalidTournamentException(String message) {

        super("invalid data for tournament:  " + message);
    }
}
