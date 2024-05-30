package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();
        init(pm);
    }

    public static void init(ProjectManager pm) {
        // i. Create two customers
        Customer firstCustomer = new Customer("John","Doe", new Phone("000"));
        Customer secondCustomer = new Customer("Jane","Doe", new Phone("1234567890"));

        pm.addCustomer(firstCustomer);
        pm.addCustomer(secondCustomer);

        // ii. Create two employees
        Employee developer = new Employee("Alice Johnson", "alice@example.com");
        Employee manager = new Employee("Bob Smith", "bob@example.com");

        pm.addEmployee(manager);
        pm.addEmployee(developer);

        // iii. Create a project linked to the first customer

        Date projectStartDate = new Date();
        Date projectEndDate = new Date(projectStartDate.getTime() + (100 * 24 * 60 * 60 * 1000L)); // 100 days later
        Project project = new Project("New Web Development", "Development of a new web platform", ProjectType.WEB_DEVELOPMENT, projectStartDate, projectEndDate, 50000);

        // Linking customer to the project
        project.setCustomer(firstCustomer);

        // Adding manager and developers
        project.setManager(manager);
        project.addDeveloper(developer);

        // iv. Create two tasks and add them to the project
        Task designTask = new Task("Website Design", "Design the aesthetic aspects", new Date(), new Date(), TaskType.DESIGN);
        Task codingTask = new Task("Backend Development", "Develop the server-side logic", new Date(), new Date(), TaskType.PROGRAMMING);
        designTask.addEffort(10);
        codingTask.addEffort(20);

        project.addTask(designTask);
        project.addTask(codingTask);

        // Adding project to the project manager's list and customer's list
        pm.addProject(project);
        pm.getCustomer("John", "Doe").addProject(project);


        // v. Print the data of the first employee
        System.out.println("-First customer \n" +
                "Name: " + pm.getCustomer("John", "Doe").getName()
                + "\nSurname: " + pm.getCustomer("John", "Doe").getSurname()
                + "\nPhone: " + pm.getCustomer("John", "Doe").getPhone());

        // vi. Print the data of the manager
        System.out.println("-Manager \n" +
                "Name: " + pm.getEmployee("Bob Smith").getName()
                + "\nEmail: " + pm.getEmployee("Bob Smith").getEmail());
        // vii. Print the data of the first project

        Customer customer = pm.getCustomer("John", "Doe");
        Project project1 = customer.getProjects().get(0);
        printProjectDetails(project1);

        // viii. Print the tasks of the first project
        printProjectTasks(project1);
        // ix. Remove the second customer
        pm.removeCustomer("Jane Doe");

        // x. Print the number of customers
        System.out.println("Number of customers: " + pm.getCustomerCount());
    }
    private static void printProjectDetails(Project project) {
        System.out.println("-Project Name: " + project.getName()
                + "\nDescription: " + project.getDescription()
                + "\nType: " + project.getType()
                + "\nStart Date: " + project.getContract().getStartDate().toString()
                + "\nEnd Date: " + project.getContract().getEndDate().toString()
                + "\nBudget: " + project.getContract().getBudget()
                + "\nManager: " + project.getManager().getName()
                + "\nCustomer: " + project.getCustomer().getName()
                + "\nDevelopers: " + project.getDevelopers().get(0).getName());
        for (Task task : project.getTasks()) {
            System.out.println("Task: " + task.getName());
        }
    }
    private static void printProjectTasks(Project project) {
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
