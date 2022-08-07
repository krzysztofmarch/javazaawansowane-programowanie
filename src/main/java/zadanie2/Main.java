package src.main.java.zadanie2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee dariusz = new Employee(1, "Dariusz", "86860979");
//        Employee jakub = new Employee(2, "Jakub", "6468468");
//        Employee marek = new Employee(3, "Marek", "34863463");

        EmployeeRepository employeeSet = new EmployeeRepositorySet();
        employeeSet.add(dariusz);
//        employeeSet.add(jakub);
//        employeeSet.add(marek);
//        System.out.println(employeeSet);
//
//        employeeSet.remove("6468468");
//        System.out.println(employeeSet);
//
//        System.out.println("*".repeat(40));
//        employeeSet.add(jakub);
//        System.out.println(employeeSet.getEmployees());

        EmployeeMenu menu = new EmployeeMenu(employeeSet);
        menu.start();
    }
}
