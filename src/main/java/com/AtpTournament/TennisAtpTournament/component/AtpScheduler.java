package com.AtpTournament.TennisAtpTournament.component;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.repository.PlayerRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class AtpScheduler {

    private PlayerRepository playerRepository;
    private Random random = new Random();

    public AtpScheduler(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Esegue ogni giorno alle 3 di notte (esempio)
    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.DAYS)
    public void updateAtpRanking() {
        List<Player> players = playerRepository.findAll();

        for (Player player : players) {
            // Logica simulata: cambio random tra -50 e +50 punti
            int change = random.nextInt(101) - 50;
            int newRankingPoints = Math.max(player.getRankingAtp() + change, 0);
            player.setRankingAtp(newRankingPoints);
        }

        playerRepository.saveAll(players);
        System.out.println("ATP ranking aggiornato automaticamente.");
    }
}
