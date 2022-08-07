package src.main.java.zadanie2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeRepositorySet implements EmployeeRepository {

    private Set<Employee> employees = new HashSet<>();

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void remove(int id) {
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                employees.remove(employee);
                return;
            }
        }
        throw new RuntimeException("Invalid id. Employee not found!");
    }

    @Override
    public void remove(String PESEL) {
        employees = employees.stream()
                .filter(s -> !s.getPESEL().equals(PESEL))
                .collect(Collectors.toSet());
    }

    @Override
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    @Override
    public String toString() {
        return "EmployeeRepositorySet{" +
                "employees=" + employees +
                '}';
    }
}