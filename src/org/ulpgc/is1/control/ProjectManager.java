package org.ulpgc.is1.control;

import org.ulpgc.is1.model.Customer;
import org.ulpgc.is1.model.Employee;
import org.ulpgc.is1.model.Project;

import java.util.ArrayList;
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

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }
}
