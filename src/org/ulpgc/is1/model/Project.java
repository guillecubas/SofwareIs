package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private static int nextId = 0;
    private final int id;
    private String name;
    private String description;
    private ProjectType type;
    private List<Task> tasks;

    // Constructor
    public Project(String name, String description, ProjectType type) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
        this.type = type;
        this.tasks = new ArrayList<>();
    }

    // Add a task to the project
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    // Getters and Setters
    public int getId() {
        return id;
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

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
