package guinho.olympus.stats;

import java.time.Duration;

public class SimulationStats {
    private RequisitionStats requisitionStats;
    private RegisterStats registerStats;
    private LoginStats loginStats;
    private Duration duration;

    public SimulationStats() {
        this.requisitionStats = new RequisitionStats();
        this.registerStats = new RegisterStats();
        this.loginStats = new LoginStats();
    }

    public RequisitionStats getRequisitionStats() {
        return requisitionStats;
    }

    public void setRequisitionStats(RequisitionStats requisitionStats) {
        this.requisitionStats = requisitionStats;
    }

    public RegisterStats getRegisterStats() {
        return registerStats;
    }

    public void setRegisterStats(RegisterStats registerStats) {
        this.registerStats = registerStats;
    }

    public LoginStats getLoginStats() {
        return loginStats;
    }

    public void setLoginStats(LoginStats loginStats) {
        this.loginStats = loginStats;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
