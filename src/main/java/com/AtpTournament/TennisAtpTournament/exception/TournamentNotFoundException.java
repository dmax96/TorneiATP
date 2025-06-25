package com.AtpTournament.TennisAtpTournament.exception;

public class TournamentNotFoundException extends RuntimeException {
  public TournamentNotFoundException(Long id) {
    super("Tournament with id " + id + " not found");
  }
}
