package bakery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Bakery {

    private String name;
    private int capacity;
    private Collection<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee employee : employees) {
            if (employee.name.equals(this.name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public String getOldestEmployee() {
        if (employees.size() > 0) {
            return String.valueOf(this.employees.stream()
                    .max(Comparator.comparing(Employee::getAge)).get());
        } else {
            return null;
        }
    }

    public String getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return String.valueOf(employee);
            }
        }
        return null;
    }


    public int getCount() {
        return employees.size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Employees working at Bakery %s:",this.name))
                .append(System.lineSeparator());

        for (Employee employee : employees){
            sb.append(String.format(String.valueOf(employee))).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
