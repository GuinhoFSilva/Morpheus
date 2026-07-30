package guinho.olympus.commands;

import guinho.olympus.service.SimulationService;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@CommandLine.Command(name = "simulate", description = "simulates the full sign-up, login, and queuing scenario", mixinStandardHelpOptions = true, version = "1.0")
@Component
public class SimulateCommand implements Runnable{
    private final SimulationService simulationService;

    public SimulateCommand(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @CommandLine.Option(names = {"-p", "--players"}, description = "number of concurrent players for the simulation", defaultValue = "50")
    private Integer qtdPlayers;

    @Override
    public void run() {
        simulationService.simulate(qtdPlayers);
    }
}
