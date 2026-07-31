package guinho.olympus.service;

import guinho.olympus.clients.argos.ArgosRestClient;
import guinho.olympus.clients.argos.dto.LoginRequest;
import guinho.olympus.clients.argos.dto.RegisterPlayerRequest;
import guinho.olympus.clients.hermes.HermesRestClient;
import guinho.olympus.factory.PlayerFactory;
import guinho.olympus.models.SimulationPlayer;
import guinho.olympus.stats.SimulationStats;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Service
public class SimulationService {
    private final HermesRestClient hermes;
    private final ArgosRestClient argos;

    public SimulationService(HermesRestClient hermes, ArgosRestClient argos) {
        this.hermes = hermes;
        this.argos = argos;
    }

    private int normalizePlayerCount(int qtdPlayers) {
        if (qtdPlayers < 2) {
            qtdPlayers = 2;
        }

        if (qtdPlayers > 1000) {
            qtdPlayers = 1000;
        }

        return qtdPlayers;
    }

    public SimulationStats simulate(int qtdPlayers) {
        SimulationStats stats = new SimulationStats();
        qtdPlayers = normalizePlayerCount(qtdPlayers);
        Instant start = Instant.now();
        for (int i = 0; i < qtdPlayers; i++) {
            SimulationPlayer player = PlayerFactory.createPlayer();

            RegisterPlayerRequest registerRequest = new RegisterPlayerRequest(player.getNickname(), player.getEmail(), player.getPassword());

            UUID savedPlayerId = registerPlayer(registerRequest, stats);
            player.setId(savedPlayerId);

            LoginRequest loginRequest = new LoginRequest(player.getEmail(), player.getPassword());

            String playerToken = loginPlayer(loginRequest, stats);

            joinQueue(playerToken, stats);
        }

        stats.setDuration(Duration.between(start, Instant.now()));
        return stats;
    }

    public String loginPlayer(LoginRequest player, SimulationStats stats) {
        stats.getLoginStats().totalLoginAttempts();
        stats.getRequisitionStats().totalRequests();
        try {
            String playerToken = argos.login(player);
            stats.getLoginStats().successfulLoginAttempts();
            stats.getRequisitionStats().successfulRequests();
            return playerToken;
        } catch (Exception e) {
            stats.getLoginStats().failedLoginAttempts();
            throw e;
        }
    }

    private UUID registerPlayer(RegisterPlayerRequest playerRequest, SimulationStats stats) {
        stats.getRegisterStats().totalRegistrationAttempts();
        stats.getRequisitionStats().totalRequests();
        try {
            UUID savedPlayerId = argos.register(playerRequest);
            stats.getRegisterStats().successfulRegistrations();
            stats.getRequisitionStats().successfulRequests();
            return savedPlayerId;
        } catch (Exception e) {
            stats.getRegisterStats().failedRegistrations();
            stats.getRequisitionStats().failedrequests();
            throw e;
        }
    }

    private void joinQueue(String playerToken, SimulationStats stats) {
        stats.getRequisitionStats().totalRequests();
        try {
            hermes.joinQueue(playerToken);
            stats.getRequisitionStats().successfulRequests();
        } catch (Exception e) {
            stats.getRequisitionStats().failedrequests();
            throw e;
        }
    }
}
