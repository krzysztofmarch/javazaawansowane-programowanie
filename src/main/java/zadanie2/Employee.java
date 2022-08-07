package src.main.java.zadanie2;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private String PESEL;

    public Employee(int id, String name, String PESEL) {
        this.id = id;
        this.name = name;
        this.PESEL = PESEL;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPESEL() {
        return PESEL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(PESEL, employee.PESEL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, PESEL);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PESEL='" + PESEL + '\'' +
                '}';
    }
}