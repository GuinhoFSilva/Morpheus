package guinho.olympus.stats;

public class LoginStats {
    private long totalLoginAttempts;
    private long successfulLoginAttempts;
    private long failedLoginAttempts;

    public LoginStats() {
        this.totalLoginAttempts = 0;
        this.successfulLoginAttempts = 0;
        this.failedLoginAttempts = 0;
    }

    public void totalLoginAttempts() {
        this.totalLoginAttempts++;
    }

    public void successfulLoginAttempts() {
        this.successfulLoginAttempts++;
    }

    public void failedLoginAttempts() {
        this.failedLoginAttempts++;
    }

    public long getRequestedRegisters() {
        return totalLoginAttempts;
    }

    public void setRequestedRegisters(long totalLoginAttempts) {
        this.totalLoginAttempts = totalLoginAttempts;
    }

    public long getSuccessfulRegisters() {
        return successfulLoginAttempts;
    }

    public void setSuccessfulRegisters(long successfulLoginAttempts) {
        this.successfulLoginAttempts = successfulLoginAttempts;
    }

    public long getFailures() {
        return failedLoginAttempts;
    }

    public void setFailures(long failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }
}
