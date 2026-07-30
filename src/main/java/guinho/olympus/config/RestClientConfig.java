package guinho.olympus.config;

import guinho.olympus.clients.argos.ArgosRestClient;
import guinho.olympus.clients.hermes.HermesRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${argos.url}")
    private String argosUrl;
    @Value("${hermes.url}")
    private String hermesUrl;

    @Bean
    public ArgosRestClient argosRestClient () {
        RestClient restClient = RestClient.builder()
                .baseUrl(argosUrl)
                .build();
        return new ArgosRestClient(restClient);
    }

    @Bean
    public HermesRestClient hermesRestClient () {
        RestClient restClient = RestClient.builder()
                .baseUrl(hermesUrl)
                .build();
        return new HermesRestClient(restClient);
    }
}
