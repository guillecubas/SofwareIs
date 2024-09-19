package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private static int nextId = 0;
    private final int id;
    private String name;
    private String description;
    private ProjectType type;
    private List<Task> tasks;
    private ArrayList<Employee> developers;
    private Employee manager;
    private Customer customer;
    private Contract contract;

    // Constructor
    public Project(String name, String description, ProjectType type, Date start, Date end, int budget, Customer customer, Employee manager) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
        this.type = type;
        this.tasks = new ArrayList<>();
        this.developers = new ArrayList<>();
        this.contract = new Contract(start, end, budget);
        this.customer = customer;
        this.manager = manager;
    }

    public void addTask(String name, String description, Date start, Date end, TaskType type) {
        Task task = new Task(name, description, start, end, type);
        this.tasks.add(task);
    }


    public void addDeveloper(Employee developer) { 
        this.developers.add(developer);
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
    public void setManager(Employee manager) {
        this.manager = manager;
    }
    public Employee getManager() {
        return manager;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<Employee> getDevelopers() {
        return developers;
    }
    public  Employee getDeveloper(String name){
        for (Employee developer : developers) {
            if (developer.getName().equalsIgnoreCase(name)) {
                return developer;
            }
        }
        return null;
    }

    public Contract getContract() {
        return contract;
    }

    public void displayTaskDetails(List<Task> tasks) {
        if (tasks != null && !tasks.isEmpty()) {
            System.out.println("- Tasks:");
            for (Task task : tasks) {
                System.out.println("  Task: " + task.getName()
                        + "\n  Description: " + task.getDescription()
                        + "\n  Start Date: " + task.getStart()
                        + "\n  End Date: " + task.getEnd()
                        + "\n  Type: " + task.getType()
                        + "\n  Effort: " + task.getEfforts().stream().mapToInt(Effort::getAmount).sum() + " hours");
            }
        }
    }
    private void displayEmployeeDetails(Employee employee) {
        if (employee != null) {
            System.out.println("- Employee: " + employee.getName()
                    + "\nEmail: " + employee.getEmail());
        }
    }
    private Task getTask(String name) {
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(name)) {
                return task;
            }
        }
        return null;
    }
}
