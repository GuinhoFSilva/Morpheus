package guinho.olympus.clients.argos;

import guinho.olympus.clients.argos.dto.LoginRequest;
import guinho.olympus.clients.argos.dto.LoginResponse;
import guinho.olympus.clients.argos.dto.RegisterPlayerRequest;
import guinho.olympus.clients.argos.dto.RegisterPlayerResponse;
import org.springframework.web.client.RestClient;

import java.util.UUID;

public class ArgosRestClient implements ArgosClient{
    private final RestClient restClient;

    public ArgosRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public UUID register(RegisterPlayerRequest request) {
        RegisterPlayerResponse response = restClient.post()
                .uri("/auth/register")
                .body(request)
                .retrieve()
                .body(RegisterPlayerResponse.class);

        return response.id();
    }

    @Override
    public String login(LoginRequest request) {
        LoginResponse response = restClient.post()
                .uri("/auth/login")
                .body(request)
                .retrieve()
                .body(LoginResponse.class);

        return response.token();
    }
}
