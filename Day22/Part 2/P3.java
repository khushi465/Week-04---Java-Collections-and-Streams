import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - " + age + " - " + salary;
    }
}

public class P3 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, 50000),
            new Person("Bob", 25, 60000),
            new Person("Charlie", 35, 70000)
        );

        people.stream()
              .sorted(Comparator.comparingInt(p -> p.age))
              .forEach(System.out::println);
    }
}
