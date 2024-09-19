package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private String email;
    private List<Project> projects;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.projects = new ArrayList<>();
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

    public void addProject(Project project) {
        this.projects.add(project);
    }
    public Project getProject(String name){
        for (Project project : projects) {
            if (project.getName().equalsIgnoreCase(name)) {
                return project;
            }
        }
        return null;
    }
}
