package com.AtpTournament.TennisAtpTournament.exception;

public class MatchNotFoundException extends RuntimeException {
  public MatchNotFoundException(Long id) {
    super("Tournament with id " + id + " not found");
  }
}
