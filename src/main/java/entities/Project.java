package entities;

import java.time.LocalDate;

public class Project {
    private int clientId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Project() {
    }

    public Project(int clientId, LocalDate startDate, LocalDate endDate) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
