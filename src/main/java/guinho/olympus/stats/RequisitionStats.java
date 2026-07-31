package guinho.olympus.stats;

public class RequisitionStats {
    private long totalRequests;
    private long successfulRequests;
    private long failedRequests;

    public RequisitionStats() {
        this.totalRequests = 0;
        this.successfulRequests = 0;
        this.failedRequests = 0;
    }

    public void totalRequests() {
        this.totalRequests++;
    }

    public void successfulRequests() {
        this.successfulRequests++;
    }

    public void failedrequests() {
        this.failedRequests++;
    }

    public long getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(long totalRequests) {
        this.totalRequests = totalRequests;
    }

    public long getSuccessfulRequests() {
        return successfulRequests;
    }

    public void setSuccessfulRequests(long successfulRequests) {
        this.successfulRequests = successfulRequests;
    }

    public long getFailedRequests() {
        return failedRequests;
    }

    public void setFailedRequests(long failedRequests) {
        this.failedRequests = failedRequests;
    }
}
