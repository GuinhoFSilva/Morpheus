package guinho.olympus;


import guinho.olympus.commands.MorpheusCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
public class MorpheusRunner implements CommandLineRunner {
    private final MorpheusCommand command;
    private final CommandLine.IFactory iFactory;

    public MorpheusRunner(MorpheusCommand command, CommandLine.IFactory iFactory) {
        this.command = command;
        this.iFactory = iFactory;
    }

    @Override
    public void run(String... args) throws Exception {
        printBanner();
        int exitCode = new CommandLine(command, iFactory).execute(args);

        System.exit(exitCode);
    }

    private void printBanner() {
        System.out.println("""
                 ███▄ ▄███▓ ▒█████   ██▀███   ██▓███   ██░ ██ ▓█████  █    ██   ██████\s
                ▓██▒▀█▀ ██▒▒██▒  ██▒▓██ ▒ ██▒▓██░  ██▒▓██░ ██▒▓█   ▀  ██  ▓██▒▒██    ▒\s
                ▓██    ▓██░▒██░  ██▒▓██ ░▄█ ▒▓██░ ██▓▒▒██▀▀██░▒███   ▓██  ▒██░░ ▓██▄  \s
                ▒██    ▒██ ▒██   ██░▒██▀▀█▄  ▒██▄█▓▒ ▒░▓█ ░██ ▒▓█  ▄ ▓▓█  ░██░  ▒   ██▒
                ▒██▒   ░██▒░ ████▓▒░░██▓ ▒██▒▒██▒ ░  ░░▓█▒░██▓░▒████▒▒▒█████▓ ▒██████▒▒
                ░ ▒░   ░  ░░ ▒░▒░▒░ ░ ▒▓ ░▒▓░▒▓▒░ ░  ░ ▒ ░░▒░▒░░ ▒░ ░░▒▓▒ ▒ ▒ ▒ ▒▓▒ ▒ ░
                ░  ░      ░  ░ ▒ ▒░   ░▒ ░ ▒░░▒ ░      ▒ ░▒░ ░ ░ ░  ░░░▒░ ░ ░ ░ ░▒  ░ ░
                ░      ░   ░ ░ ░ ▒    ░░   ░ ░░        ░  ░░ ░   ░    ░░░ ░ ░ ░  ░  ░ \s
                       ░       ░ ░     ░               ░  ░  ░   ░  ░   ░           ░ \s
                                                                                      \s
                """);
    }
}