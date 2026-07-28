package guinho.olympus.factory;

import guinho.olympus.models.SimulationPlayer;
import net.datafaker.Faker;

import java.util.concurrent.atomic.AtomicLong;

public class PlayerFactory {
    private static final Faker FAKER = new Faker();
    private static final AtomicLong ATOMIC_LONG = new AtomicLong(System.nanoTime());

    public static SimulationPlayer createPlayer() {
        String suffix = Long.toString(ATOMIC_LONG.getAndIncrement(), 36);
        String name = FAKER.name().firstName();
        String shortName = name.substring(0, Math.min(name.length(), 20 - suffix.length()));
        String nickname =  shortName + suffix;
        String email = nickname + "@morpheustest.com";
        String password = suffix + "Strong!123";
        return new SimulationPlayer(nickname, email, password);
    }
}
