package guinho.olympus;


import guinho.olympus.commands.MorpheusCommand;
import guinho.olympus.presentation.MorpheusPrinter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.Scanner;

@Component
public class MorpheusRunner implements CommandLineRunner {
    private final MorpheusCommand command;
    private final CommandLine.IFactory iFactory;
    private final MorpheusPrinter printer = new MorpheusPrinter();

    public MorpheusRunner(MorpheusCommand command, CommandLine.IFactory iFactory) {
        this.command = command;
        this.iFactory = iFactory;
    }

    @Override
    public void run(String... args) throws Exception {
        printer.printBanner();
        startCli();
    }

    private void startCli() {
        Scanner scanner = new Scanner(System.in);
        CommandLine cli = new CommandLine(command, iFactory);
        while (true) {
            System.out.print("Morpheus> ");

            String line = scanner.nextLine();

            if (line.equals("exit")) {
                break;
            }

            cli.execute(line.split("\\s+"));
        }
    }
}