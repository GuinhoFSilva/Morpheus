package guinho.olympus.commands;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

@CommandLine.Command(
        name = "morpheus",
        mixinStandardHelpOptions = true,
        version = "morpheus 1.0",
        description = "Official Olympus CLI for simulations",
        subcommands = {SimulateCommand.class}
)
@Component
public class MorpheusCommand {
}
