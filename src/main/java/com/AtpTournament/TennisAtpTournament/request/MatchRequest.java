package com.AtpTournament.TennisAtpTournament.request;

public class MatchRequest {
    private Long idTournament;
    private Long idPlayerOne;
    private Long idPlayerTwo;


    public MatchRequest(){

    }

    public MatchRequest(Long idTournament, Long idPlayerOne, Long idPlayerTwo) {
        this.idTournament = idTournament;
        this.idPlayerOne = idPlayerOne;
        this.idPlayerTwo = idPlayerTwo;
    }

    public Long getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(Long idTournament) {
        this.idTournament = idTournament;
    }

    public Long getIdPlayerOne() {
        return idPlayerOne;
    }

    public void setIdPlayerOne(Long idPlayerOne) {
        this.idPlayerOne = idPlayerOne;
    }

    public Long getIdPlayerTwo() {
        return idPlayerTwo;
    }

    public void setIdPlayerTwo(Long idPlayerTwo) {
        this.idPlayerTwo = idPlayerTwo;
    }
}
