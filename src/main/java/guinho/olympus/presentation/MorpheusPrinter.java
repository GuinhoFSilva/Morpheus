package guinho.olympus.presentation;

import guinho.olympus.stats.SimulationStats;

public class MorpheusPrinter {
    public void printBanner() {
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

    public void startSimulation() {
        System.out.println("""
                ===========================================
                            MORPHEUS SIMULATE
                ===========================================
                
                Entering the dream...
                
                Nothing is real.
                Everything can be tested.
                """);

        System.out.println("Dream sequence initiated...");
    }

    public void endSimulation(SimulationStats stats) {
        System.out.printf("""
                ===========================================
                          MORPHEUS SIMULATION REPORT
                ===========================================
               
                The dream has been analyzed.
               
                Requisitions
                ------------
                Total      : %d
                Successful : %d
                Failed     : %d
               
                Registrations
                -------------
                Total      : %d
                Successful : %d
                Failed     : %d
               
                Logins
                ------
                Total      : %d
                Successful : %d
                Failed     : %d
               
                Execution
                ---------
                Duration   : %d s
               
                ===========================================
                Simulation complete.
                The Dream is over...
                Welcome back.
                ===========================================
                %n""",
                stats.getRequisitionStats().getTotalRequests(),
                stats.getRequisitionStats().getSuccessfulRequests(),
                stats.getRequisitionStats().getFailedRequests(),
                stats.getRegisterStats().getRequestedRegisters(),
                stats.getRegisterStats().getSuccessfulRegisters(),
                stats.getRegisterStats().getFailures(),
                stats.getLoginStats().getRequestedRegisters(),
                stats.getLoginStats().getSuccessfulRegisters(),
                stats.getLoginStats().getFailures(),
                stats.getDuration().toSeconds()
                );
    }

    public void goodbye() {
        System.out.println("Wake up.");
    }
}
