package org.ulpgc.is1.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Task {
    private String name;
    private String description;
    private Date start;
    private Date end;
    private TaskType type;
    private List<Effort> efforts;

    public Task(String name, String description, Date start, Date end, TaskType type) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.type = type;
        this.efforts = new ArrayList<>();
    }

    public void addEffort(int amount, Employee employee) {
        Effort effort = new Effort(amount,this, employee);
        this.efforts.add(effort);

    }

    public List<Effort> getEfforts() {
        return efforts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public void setEfforts(List<Effort> efforts) {
        this.efforts = efforts;
    }

    public Effort getEffort(int amount, Employee employee) {
        for (Effort effort : efforts) {
            if (effort.getAmount() == amount 
                && effort.getEmployee().equals(employee)
                && effort.getTask().equals(this)) {
                return effort;
            }
        }
        return null;
    }

    public void deleteEffort(Effort effort) {
        this.efforts.remove(effort);
    }
    public void addEffort(Effort effort) {
        this.efforts.add(effort);
        
    }
}
