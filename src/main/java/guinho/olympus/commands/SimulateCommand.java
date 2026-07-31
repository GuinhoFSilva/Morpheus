package guinho.olympus.commands;

import guinho.olympus.presentation.MorpheusPrinter;
import guinho.olympus.service.SimulationService;
import guinho.olympus.stats.SimulationStats;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.io.PrintWriter;

@CommandLine.Command(name = "simulate", description = "simulates the full sign-up, login, and queuing scenario", mixinStandardHelpOptions = true, version = "1.0")
@Component
public class SimulateCommand implements Runnable{
    private final SimulationService simulationService;
    private final MorpheusPrinter printer = new MorpheusPrinter();

    public SimulateCommand(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @CommandLine.Option(names = {"-p", "--players"}, description = "number of concurrent players for the simulation", defaultValue = "50")
    private Integer qtdPlayers;

    @Override
    public void run() {
        printer.startSimulation();
        SimulationStats stats = simulationService.simulate(qtdPlayers);
        printer.endSimulation(stats);
    }
}
