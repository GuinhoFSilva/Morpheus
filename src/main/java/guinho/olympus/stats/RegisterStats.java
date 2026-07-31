package guinho.olympus.stats;

public class RegisterStats {
    private long totalRegistrationAttempts;
    private long successfulRegistrations;
    private long failedRegistrations;

    public RegisterStats() {
        this.totalRegistrationAttempts = 0;
        this.successfulRegistrations = 0;
        this.failedRegistrations = 0;
    }

    public void totalRegistrationAttempts() {
        this.totalRegistrationAttempts++;
    }

    public void successfulRegistrations() {
        this.successfulRegistrations++;
    }

    public void failedRegistrations() {
        this.failedRegistrations++;
    }

    public long getRequestedRegisters() {
        return totalRegistrationAttempts;
    }

    public void setRequestedRegisters(long totalRegistrationAttempts) {
        this.totalRegistrationAttempts = totalRegistrationAttempts;
    }

    public long getSuccessfulRegisters() {
        return successfulRegistrations;
    }

    public void setSuccessfulRegisters(long successfulRegistrations) {
        this.successfulRegistrations = successfulRegistrations;
    }

    public long getFailures() {
        return failedRegistrations;
    }

    public void setFailures(long failedRegistrations) {
        this.failedRegistrations = failedRegistrations;
    }
}
