package guinho.olympus.clients.argos;

import guinho.olympus.clients.argos.dto.LoginRequest;
import guinho.olympus.clients.argos.dto.RegisterPlayerRequest;

import java.util.UUID;

public interface ArgosClient {

    UUID register(RegisterPlayerRequest request);

    String login(LoginRequest request);

}
