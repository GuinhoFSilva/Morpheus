package guinho.olympus.clients.hermes;

public interface HermesClient {
    boolean joinQueue(String token);
    void leaveQueue(String token);
}
