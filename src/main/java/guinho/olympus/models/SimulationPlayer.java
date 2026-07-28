package guinho.olympus.models;

import java.util.UUID;

public class SimulationPlayer {
    private UUID id;
    private String nickname;
    private String email;
    private String password;
    private String token;

    public SimulationPlayer(UUID id, String nickname, String email, String password, String token) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public SimulationPlayer(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public SimulationPlayer() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SimulationPlayer{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
