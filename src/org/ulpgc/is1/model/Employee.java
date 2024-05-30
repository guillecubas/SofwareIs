package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String email;
    private List<Task> tasks;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
