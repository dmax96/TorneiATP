package com.AtpTournament.TennisAtpTournament.component;

import com.AtpTournament.TennisAtpTournament.entity.Player;
import com.AtpTournament.TennisAtpTournament.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class AtpScheduler {

    private PlayerRepository playerRepository;
    private Random random = new Random();

    public AtpScheduler(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.DAYS)
    public void updateAtpRanking() {
        log.info("Updating Atp Ranking...");
        List<Player> players = playerRepository.findAll();

        if(players.isEmpty()) {
            log.warn("No players found");
            return;
        }

        for (Player player : players) {
            int change = random.nextInt(101) - 50;
            int newRankingPoints = Math.max(player.getRankingAtp() + change, 0);
            player.setRankingAtp(newRankingPoints);
        }

        playerRepository.saveAll(players);
        log.info("Atp Ranking updated!");
    }
}
