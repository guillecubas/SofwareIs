

import java.util.ArrayList;
import java.util.List;

public class Project {
    private static int NEXT_ID = 1;
    private int projectId;
    private String name;
    private String description;
    private int budget;
    private List<Task> tasks;

    public Project(String name, String description, int budget) {
        this.projectId = NEXT_ID++;
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    // Getters and setters...

    public static int getNextId() {
        return NEXT_ID;
    }

    public static void setNextId(int nextId) {
        NEXT_ID = nextId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
