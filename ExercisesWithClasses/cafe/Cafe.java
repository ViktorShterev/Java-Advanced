package ExercisesWithClasses.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee oldest = new Employee("", 0, "");
        for (Employee employee : this.employees) {
            if (employee.getAge() > oldest.getAge()) {
                oldest = employee;
            }
        }
        return oldest;
    }
    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
    public int getCount() {
        return this.employees.size();
    }
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Employees working at Cafe " + this.name + ":").append(System.lineSeparator());
        this.employees.forEach(e -> stringBuilder.append(e.toString()).append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}
