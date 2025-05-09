import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return String.format("Employee{id=%d, name='%s', dept='%s', salary=%.2f}", id, name, department, salary);
    }
}

class EmployeeProcessor {
    public static Map<String, Double> processEmployees(List<Employee> employees) {
        List<Employee> filtered = employees.stream()
                .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        // Display filtered & sorted employees
        System.out.println("Filtered & Sorted Employees:");
        filtered.forEach(System.out::println);

        // Group and aggregate (average salary per department)
        return filtered.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }
}

public class P1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "Engineering", 85000),
                new Employee(3, "Charlie", "HR", 75000),
                new Employee(4, "David", "Engineering", 70000),
                new Employee(5, "Eve", "Engineering", 95000),
                new Employee(6, "Frank", "Marketing", 88000),
                new Employee(7, "Grace", "Engineering", 82000)
        );

        Map<String, Double> avgSalaries = EmployeeProcessor.processEmployees(employees);

        System.out.println("\nAverage Salary per Department (after filtering):");
        avgSalaries.forEach((dept, avg) -> System.out.println(dept + ": $" + avg));
    }
}
