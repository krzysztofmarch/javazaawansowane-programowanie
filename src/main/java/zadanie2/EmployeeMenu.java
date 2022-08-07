package src.main.java.zadanie2;

import java.util.Scanner;

public class EmployeeMenu {

    private static final String menu = "Menu:\n" +
            "1.dodaj pracownika\n" +
            "2.usun pracownika po employeeId\n" +
            "3.usun pracownika po pesel\n" +
            "4.wyswielt liste pracownikow\n" +
            "0. Aby wyjsc";
    private final Scanner sc = new Scanner(System.in);
    private EmployeeRepository employeeRepository;

    public EmployeeMenu(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void start() {

        while (true) {
            displayMenu();
            int input = Integer.valueOf(sc.nextLine());
            switch (input) {
                case 1:
                    System.out.println("Podaj imie: ");
                    String name = sc.nextLine();
                    System.out.println("Podaj id: ");
                    int id = Integer.valueOf(sc.nextLine());
                    System.out.println("Podaj PESEL: ");
                    String PESEL = sc.nextLine();
                    Employee employee = new Employee(id, name, PESEL);
                    employeeRepository.add(employee);
                    break;
                case 2:
                    System.out.println("Podaj employeeId: ");
                    int idToRemove = Integer.valueOf(sc.nextLine());
                    try {
                        employeeRepository.remove(idToRemove);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Podaj PESEL: ");
                    String PESELToRemove = sc.nextLine();
                    employeeRepository.remove(PESELToRemove);
                    break;
                case 4:
                    System.out.println(employeeRepository.getEmployees());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wprowadz poprawny input.");
            }
        }
    }

    private void displayMenu() {
        System.out.println(menu);
    }
}