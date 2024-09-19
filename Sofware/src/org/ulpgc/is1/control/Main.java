package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();
        init(pm);

        // Add effort to the first task of the first project

        Customer firstCustomer = pm.getCustomer(0);

        Project project = firstCustomer.getProjects().get(0);
        Task task = project.getTasks().get(0);
        task.addEffort(10, pm.getEmployee(1));

        // Add effort to the second task of the first project
        Task task2 = project.getTasks().get(1);
        task2.addEffort(20, pm.getEmployee(1));

        //  Print the data of the first employee
        System.out.println("-First customer \n" +
                "Name: " + pm.getCustomer(0).getName()
                + "\nSurname: " + pm.getCustomer(0).getSurname()
                + "\nPhone: " + pm.getCustomer(0).getPhone());

        //  Print the data of the manager
        System.out.println("-Manager \n" +
                "Name: " + pm.getEmployee(0).getName()
                + "\nEmail: " + pm.getEmployee(0).getEmail());
        //  Print the data of the first project

        Customer customer = pm.getCustomer(0);
        Project project1 = customer.getProjects().get(0);
        project1.getName();
        printProjectDetails(project1);

        // Print the tasks of the first project
        printProjectTasks(project1);
        // Remove the second customer
        pm.removeCustomer("Jane", "Doe");

        // Print the number of customers
        System.out.println("Number of customers: " + pm.countCustomer());
    }

    public static void init(ProjectManager pm) {
        // i. Create two customers
        pm.addCustomer("John","Doe", new Phone("+34666555444"));
        pm.addCustomer("Jane","Doe", new Phone("1321312312"));
        // ii. Create two employees

        pm.addEmployee("Alice Johnson", "alice@example.com");
        pm.addEmployee("Bob Smith", "bob@example.com");
        // iii. Create a project linked to the first customer

        Date projectStartDate = new Date();
        Date projectEndDate = new Date(projectStartDate.getTime() + (100 * 24 * 60 * 60 * 1000L)); // 100 days later
        pm.addProject("New Web Development", "Development of a new web platform", ProjectType.WEB_DEVELOPMENT, projectStartDate, projectEndDate, 50000, pm.getCustomer(0), pm.getEmployee(0));

        // iv. Create two tasks and add them to the project and the developer
        Customer firstCustomer = pm.getCustomer(0);
        Project project = firstCustomer.getProjects().get(0);
        project.addDeveloper(pm.getEmployee(1));

        project.addTask("Backend Development", "Develop the server-side logic", new Date(), new Date(), TaskType.PROGRAMMING);
        project.addTask("Frontend Development", "Create the user interface and client-side logic", new Date(), new Date(System.currentTimeMillis() + (10 * 24 * 60 * 60 * 1000L)), TaskType.PROGRAMMING);






    }
    private static void printProjectDetails(Project project) {
        System.out.println("-Project Name: " + project.getName()
                + "\nDescription: " + project.getDescription()
                + "\nType: " + project.getType()
                + "\nStart Date: " + project.getContract().getStartDate().toString()
                + "\nEnd Date: " + project.getContract().getEndDate().toString()
                + "\nBudget: " + project.getContract().getBudget()
                + "\nManager: " + project.getManager().getName()
                + "\nCustomer: " + project.getCustomer().getName());

        // Check if there are any developers
        if (!project.getDevelopers().isEmpty()) {
            System.out.println("Developers: " + project.getDevelopers().get(0).getName());
        } else {
            System.out.println("Developers: No developers assigned.");
        }

        // Print the tasks in the project
        for (Task task : project.getTasks()) {
            System.out.println("Task: " + task.getName());
        }
    }
    private static void printProjectTasks(Project project) {
        if (project.getTasks().isEmpty()) {
            System.out.println("No tasks available in the project.");
            return;
        }
        List<Task> tasks = project.getTasks();
        System.out.println("-Tasks of project " + project.getName() + ":");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println("Task " + (i + 1) + ": " + task.getName()
                    + "\nDescription: " + task.getDescription()
                    + "\nStart Date: " + task.getStart()
                    + "\nEnd Date: " + task.getEnd()
                    + "\nType: " + task.getType());
            for (Effort effort : task.getEfforts()) {
                System.out.println("Effort: " + effort.getAmount());
            }
        }
    }
}
