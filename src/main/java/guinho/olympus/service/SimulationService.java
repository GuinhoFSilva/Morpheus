package guinho.olympus.service;

import guinho.olympus.clients.argos.ArgosRestClient;
import guinho.olympus.clients.argos.dto.LoginRequest;
import guinho.olympus.clients.argos.dto.RegisterPlayerRequest;
import guinho.olympus.clients.hermes.HermesRestClient;
import guinho.olympus.factory.PlayerFactory;
import guinho.olympus.models.SimulationPlayer;
import org.springframework.stereotype.Service;

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
        if(qtdPlayers < 2) {
            qtdPlayers = 2;
        }

        if (qtdPlayers > 1000) {
            qtdPlayers = 1000;
        }

        return qtdPlayers;
    }

    public void simulate(int qtdPlayers) {
        qtdPlayers = normalizePlayerCount(qtdPlayers);
        for (int i = 0; i < qtdPlayers; i++) {
            SimulationPlayer player = PlayerFactory.createPlayer();

            RegisterPlayerRequest registerRequest = new RegisterPlayerRequest(player.getNickname(), player.getEmail(),  player.getPassword());

            UUID savedPlayerId = argos.register(registerRequest);
            player.setId(savedPlayerId);

            LoginRequest loginRequest = new LoginRequest(player.getEmail(), player.getPassword());

            String playerToken = argos.login(loginRequest);

            hermes.joinQueue(playerToken);
        }

    }
}
