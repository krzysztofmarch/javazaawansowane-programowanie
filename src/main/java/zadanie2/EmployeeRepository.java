package src.main.java.zadanie2;

import java.util.List;


public interface EmployeeRepository {

    void add(Employee employee);

    void remove(int id);

    void remove(String PESEL);

    List<Employee> getEmployees();
}