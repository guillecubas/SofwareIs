package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ProjectManager {
    private List<Customer> customers;
    private List<Employee> employees;
    private List<Project> projects;

    public ProjectManager() {
        this.customers = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public void addCustomer(String name, String surname, Phone phone) {
        this.customers.add(new Customer(name, surname, phone));
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public int countCustomer() {
        return customers.size();
    }

    public void removeCustomer(String name, String surname) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name) && customer.getSurname().equalsIgnoreCase(surname)) {
                customers.remove(customer);
                break;
            }
        }
    }

    public void addEmployee(String name, String email) {
        this.employees.add(new Employee(name, email));
    }

    public Employee getEmployee(int index) {
          return employees.get(index);
    }

    public void addProject(String name, String description, ProjectType type, Date start, Date end, int budget, Customer customer, Employee manager) {
        Project project = new Project(name, description, type, start, end, budget, customer, manager);
        this.projects.add(project);
        customer.addProject(project);
        for (Employee employee : employees) {
            employee.addProject(project);
        }
        manager.addProject(project);
    }


    public List<Customer> getCustomers() {
        return customers;
    }
}

