package guinho.olympus.clients.hermes;

import guinho.olympus.clients.hermes.dto.JoinQueueResponse;
import org.springframework.web.client.RestClient;

public class HermesRestClient implements HermesClient {
    private final RestClient restClient;

    public HermesRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public boolean joinQueue(String token) {
        JoinQueueResponse response = restClient.post()
                .uri("/matches/queue")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .body(JoinQueueResponse.class);

        return response.hasMatch();
    }

    @Override
    public void leaveQueue(String token) {
        restClient.delete()
                .uri("/matches/queue")
                .header("Authorization", "Bearer " + token);
    }
}
