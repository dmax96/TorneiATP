package com.AtpTournament.TennisAtpTournament.exception;

import lombok.extern.slf4j.Slf4j;

public class TournamentNotFoundException extends RuntimeException {

  public TournamentNotFoundException(Long id) {

    super("Tournament with id " + id + " not found");
  }
}
