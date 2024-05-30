package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String surname;
    private Phone phone;
    private List<Project> projects;

    public Customer(String name, String surname, Phone phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.projects = new ArrayList<>();
    }
    public void addProject(Project project) {
        this.projects.add(project);
    }

    public boolean removeProject(Project project) {
        return this.projects.remove(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone.getNumber();
    }

    public void setPhone(String number) {
        phone.setNumber(number);
    }
}
