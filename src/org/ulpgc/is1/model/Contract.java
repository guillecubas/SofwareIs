package org.ulpgc.is1.model;

import java.util.Date;

public class Contract {
    private Date startDate;
    private Date endDate;
    private int budget;

    public Contract(Date startDate, Date endDate, int budget) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
